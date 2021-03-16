package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class DbService {
    public List<ResponseModel> getResponses(){

        Iterable<ResponseModel> i = ResponseGraphApplication.repo.findAll();
        List<ResponseModel> rmList = new ArrayList<>();
        Iterator<ResponseModel> iterator = i.iterator();
        while(iterator.hasNext()){
            rmList.add(iterator.next());
        }

        return rmList;
    }

    public void saveToDb(Long dateInMilis, Long responseTime){
        ResponseModel rm = new ResponseModel(new Date(dateInMilis), responseTime);
        ResponseGraphApplication.repo.save(rm);
        System.out.println("Saved:\n" + rm.toString());
    }
}
