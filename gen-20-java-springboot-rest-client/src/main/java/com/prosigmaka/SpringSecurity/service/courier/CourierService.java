package com.prosigmaka.SpringSecurity.service.courier;

import com.prosigmaka.SpringSecurity.model.courier.CourierCity;
import com.prosigmaka.SpringSecurity.model.courier.CourierCost;
import com.prosigmaka.SpringSecurity.model.courier.CourierProvince;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourierService {
    private final RestClient restClient;
    private final String apikey = "2729342fee5d373d3b328adb799e00f2";


    public CourierService(){
        restClient = RestClient.builder()
                .baseUrl("https://api.rajaongkir.com/starter")
                .build();
    }

    public List<CourierProvince> findAll(){
        var body = restClient.get()
                .uri("/province").header("key",apikey)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {}); //body jika get jadi parameter untuk nerima, jika post jadi request
        Map<String,Object> objectMap = (Map<String, Object>) body.get("rajaongkir");
        List<Map<String, String>> result = (List<Map<String, String>>) objectMap.get("results");

        List<CourierProvince> provinces = new ArrayList<>();
        for(Map<String, String> data : result){
            provinces.add(new CourierProvince(data.get("province_id"), data.get("province") ));
        }
        return provinces;
    }

    public CourierProvince findProvinceById(String id){
        var body = restClient.get()
                .uri("/province?id="+ id).header("key",apikey)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String,Object>>() {});
        Map<String, Object> object = (Map<String, Object>) body.get("rajaongkir");
        Map<String, String> results = (Map<String,String>) object.get("results");

        CourierProvince province = new CourierProvince(results.get("province_id"), results.get("province"));

        return province;
    }

    public List<CourierCity> findAllCity(){
        var body = restClient.get()
                .uri("/city").header("key",apikey)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});
        Map<String, Object> object = (Map<String, Object>) body.get("rajaongkir");
        List<Map<String, String>> results = (List<Map<String,String>>) object.get("results");

        List<CourierCity> city = new ArrayList<>();
        for(Map<String, String> data : results){
            city.add(new CourierCity(data.get("city_id"), data.get("province_id"),data.get("province"),
                    data.get("type"), data.get("city_name"), data.get("postal_code") ));
        }
        return city;
    }

    public CourierCity findCityById(String id){
        var body = restClient.get()
                .uri("/city?id="+ id).header("key",apikey)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String,Object>>() {});
        Map<String,Object> object = (Map<String, Object>) body.get("rajaongkir");
        Map<String,String> results = (Map<String,String>) object.get("results");

        CourierCity city = new CourierCity(
                results.get("city_id"),
                results.get("province_id"),
                results.get("province"),
                results.get("type"),
                results.get("city_name"),
                results.get("postal_code"));

        return city;
    }

    public CourierCost findCost(CourierCost courierCost){
        return restClient.post()
                .uri("/cost").header("key",apikey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(courierCost)
                .retrieve()
                .body(CourierCost.class);
    }

}
