package com.prosigmaka.SpringSecurity.repository;

import com.prosigmaka.SpringSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

}
