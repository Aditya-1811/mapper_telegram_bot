package com.example.mapping.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.mapping.Primary.Repository",
        mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {

}