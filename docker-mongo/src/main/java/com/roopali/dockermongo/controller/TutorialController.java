package com.roopali.dockermongo.controller;

import com.roopali.dockermongo.dao.MongoRepositoryDao;
import com.roopali.dockermongo.domain.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tutorial")
public class TutorialController {

    @Autowired
    private MongoRepositoryDao mongoRepositoryDao;

    @GetMapping("/test")
    public String test(){
       return "Hello";
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        try {
            Tutorial addedData = mongoRepositoryDao.save(new Tutorial(tutorial.getTutorialName(), tutorial.getDesc(), tutorial.getPublished()));
            return new ResponseEntity<>(addedData, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTutorial(@PathVariable("id") String id){
        try {
            mongoRepositoryDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials")
    public ResponseEntity getAllTutorials(){
        try {
            List<Tutorial> tutorials = new ArrayList<>();
            mongoRepositoryDao.findAll().forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getAllTutorials(@PathVariable("id") String id){
        try {
            Tutorial tutorial  = mongoRepositoryDao.findById(id).get();
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
