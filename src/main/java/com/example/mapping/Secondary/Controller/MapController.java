package com.example.mapping.Secondary.Controller;

import com.example.mapping.Primary.Model.Main;
import com.example.mapping.Primary.Repository.MainRepository;
import com.example.mapping.Secondary.Model.MapClass;
import com.example.mapping.Secondary.Model.MapFunction;
import com.example.mapping.Secondary.Repository.MapRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/map")
public class MapController {

    private MapRepository repo;
    private MainRepository repo1;

    public MapController(MapRepository repo, MainRepository repo1) {
        this.repo = repo;
        this.repo1 = repo1;
    }

    @GetMapping(value = "/all")
    public List<Main> getAllMap()
    {
        return repo1.findAll();
    }


    @GetMapping(value = "/all/api1")
    public Object getAllMap1()
    {
        List<MapClass> a = repo.findAll();
        List<Main> b = repo1.findAll();
        MapFunction d = new MapFunction();
        return d.update(a, b,a.get(0).getApi_id());
    }


    @GetMapping(value = "/all/api2")
    public Object getAllMap2()
    {
        List<MapClass> a = repo.findAll();
        List<Main> b = repo1.findAll();
        MapFunction d = new MapFunction();
        return d.update(a, b,a.get(1).getApi_id());
    }


    @GetMapping(value = "/all/check")
    public Object getAllMap3()
    {
        List<MapClass> a = repo.findAll();
        List<Main> b = repo1.findAll();
        MapFunction d = new MapFunction();
        return a.get(1).getApi_id();
        //return a.get(0).getMapper().get("gender").containsKey(b.get())

        //return d.update(a, b,a.get(1).getApi_id());
    }


    /*@PutMapping(value = "/update/{id}")
    public Set<String> modifyById(@PathVariable( "id") MapClass obj, @Valid @RequestBody Main obj1) {
        List<MapClass> a = repo.findAll();
        List<Main> b = repo1.findAll();


    }*/

}
