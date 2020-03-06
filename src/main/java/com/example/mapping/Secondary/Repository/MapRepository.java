package com.example.mapping.Secondary.Repository;

import com.example.mapping.Secondary.Model.MapClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends MongoRepository<MapClass, String> {
    MapClass findByid(String id);
}
