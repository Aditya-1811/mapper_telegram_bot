package com.example.mapping.Primary.Repository;

import com.example.mapping.Primary.Model.Main;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainRepository extends MongoRepository<Main, String> {
    Main findByid(String id);
}
