package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class RestPoint {

    DbService db = new DbService();
    @GetMapping
    public List<ResponseModel> getResponse(){
       return db.getResponses();
    }
}
