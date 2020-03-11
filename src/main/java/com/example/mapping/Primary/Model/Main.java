package com.example.mapping.Primary.Model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class Main {
    @Id
    public String id;
    public String designation;
    public String name;
    public String employment;
    public String email;
    public String location;
    public String bank;
    public String gender;

}