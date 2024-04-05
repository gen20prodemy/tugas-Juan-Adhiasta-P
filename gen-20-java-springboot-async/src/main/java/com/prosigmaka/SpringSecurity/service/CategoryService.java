package com.prosigmaka.SpringSecurity.service;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import com.prosigmaka.SpringSecurity.helper.GlobalHttpResponse;
import com.prosigmaka.SpringSecurity.model.CategoryModel;
import com.prosigmaka.SpringSecurity.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        //Attempt to retrive list from Redis cache
        List<CategoryEntity> categoryEntities = (List<CategoryEntity>) redisTemplate.opsForValue().get("AllCategory");
        if(categoryEntities == null){
            categoryEntities = categoryRepo.findAll(); //if not cache, retrive from db and cache the result
            redisTemplate.opsForValue().set("AllCategory", categoryEntities);
        }
        return new GlobalHttpResponse<>(200,"Success retrive data from database",categoryEntities);
    }

    public GlobalHttpResponse<CategoryEntity> getById(int id){
        //Try to retrive from Redis cache
        CategoryEntity entity = (CategoryEntity) redisTemplate.opsForValue().get("Category:"+id);
        if(entity == null){
            Optional<CategoryEntity> searchId = categoryRepo.findById(id);
            if(searchId.isPresent()){
                entity = searchId.get();
                redisTemplate.opsForValue().set("Category:"+id, entity);
                return new GlobalHttpResponse<>(200,"Data retrive",entity);
            } else {
                return new GlobalHttpResponse<>(404,"Data not found", entity);
            }
        }
        return new GlobalHttpResponse<>(404,"Data not found", entity);
    }

    public GlobalHttpResponse<CategoryEntity> insertData(CategoryModel categoryModel){
        CategoryEntity saveModel = new CategoryEntity();
        saveModel = categoryRepo.save(categoryModel.toEntity()); //convert DTO to Entity
        redisTemplate.opsForValue().set("Category: "+ saveModel.getId(), saveModel); //also save to Redis cache
        List<CategoryEntity> entities = categoryRepo.findAll();
        redisTemplate.opsForValue().set("AllCategory", entities);
        return new GlobalHttpResponse<>(201,"Success insert data",saveModel);
    }

    public GlobalHttpResponse<CategoryEntity> updateById(int id, CategoryModel categoryModel){
        Optional<CategoryEntity> findId = categoryRepo.findById(id);
        if(findId.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new CategoryEntity());
        } else {
            CategoryEntity categoryEntity = findId.get();
            categoryEntity.setCategoryName(categoryModel.getName());
            categoryEntity.setCategoryDate(new Timestamp(System.currentTimeMillis()));
            //Update to DB
            CategoryEntity update = categoryRepo.save(categoryEntity);
            //Update redis cache for the individual category
            redisTemplate.opsForValue().set("Category:"+update.getId(), update);
            //Optionally, refresh the "AllCategory" cache tp ensure consistency
            List<CategoryEntity> entities = categoryRepo.findAll();
            redisTemplate.opsForValue().set("AllCategory", entities);
            return new GlobalHttpResponse<>(200,"Success update",categoryRepo.save(categoryEntity));
        }
    }

    public GlobalHttpResponse<CategoryEntity> deleteById(int id) {
        Optional<CategoryEntity> seekId = categoryRepo.findById(id);
        if (seekId.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new CategoryEntity());
        } else {
            CategoryEntity categoryEntity = seekId.get();
            categoryRepo.deleteById(id);
            redisTemplate.delete("Category:"+id);
            //Optionally, refresh the "AllCategory" cache to ensure consistency
            List<CategoryEntity> categoryEntities = categoryRepo.findAll();
            redisTemplate.opsForValue().set("AllCategory", categoryEntities);
            return new GlobalHttpResponse<>(200, "Data deleted", categoryEntity);
        }

    }
//    @Scheduled(cron = "* */2 * * * *") //cron expression, update every 2 minute
//    public void autoUpdateRedis(){
//        List<CategoryEntity> entities = categoryRepo.findAll();
//        redisTemplate.opsForValue().set("AllCategory", entities);
//        System.out.println("Auto update Reddis");
//    }
}
