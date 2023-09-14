package com.example.crud.controller;

import com.example.crud.models.People;
import com.example.crud.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }
    @GetMapping
    public List<People> getAll(){
        return peopleService.findAll();
    }
    @GetMapping("/{id}")
    public People getPerson(@PathVariable ("id") int id){
        return peopleService.findOne(id);
    }
    @PostMapping("/create")
    public People createPerson(@RequestBody  People people){
        return peopleService.create(people);
    }
    @PutMapping("/update/{id}")
    public People updatePeople(@PathVariable int id,@RequestBody People people){
        return peopleService.updatePeople(id,people);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePeople(@PathVariable int id){
        peopleService.deletePeople(id);
    }
}
