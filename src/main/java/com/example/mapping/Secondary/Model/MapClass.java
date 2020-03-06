package com.example.mapping.Secondary.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "map")
@Data
public class MapClass{
    @Id
    public String id;
    public Integer api_id;
    public HashMap<String, HashMap<String,String>> mapper;

}
