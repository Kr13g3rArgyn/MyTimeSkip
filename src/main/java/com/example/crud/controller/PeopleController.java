package com.example.crud.controller;

import com.example.crud.models.People;
import com.example.crud.services.PeopleService;
import com.example.crud.util.PersonErrorResponse;
import com.example.crud.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //Get one dude
    @GetMapping("/{id}")
    public People getPerson(@PathVariable ("id") int id){
        return peopleService.findOne(id);
    }

    @PostMapping("/create")
    public People createPerson(@RequestBody People people){
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
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this ID didn't found",System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);//404 - STATUS NOT FOUND
    }
}
