package com.example.crud.controller;

import com.example.crud.models.People;
import com.example.crud.services.PeopleService;
import com.example.crud.util.PersonErrorResponse;
import com.example.crud.util.PersonNotCreatedException;
import com.example.crud.util.PersonNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.example.crud.dto.PeopleDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class PeopleController {
    private final ModelMapper modelMapper;
    private final PeopleService peopleService;
    @Autowired
    public PeopleController(PeopleService peopleService, ModelMapper modelMapper) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
    }
    @GetMapping
    public List<PeopleDTO> getAll(){
        return peopleService.findAll().stream().map(this::convertToPeopleDTO)
                .collect(Collectors.toList());
    }
    //Get one dude
    @GetMapping("/{id}")
    public PeopleDTO getPerson(@PathVariable ("id") int id){
        return (convertToPeopleDTO(peopleService.findOne(id)));
    }
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createPerson(@RequestBody @Valid PeopleDTO peopleDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder msg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError fieldError : errors){ 
                msg.append(fieldError.getField())
                        .append(" - ").append(fieldError.getDefaultMessage())
                        .append(";");
            }
            throw new PersonNotCreatedException(msg.toString());
        }
        peopleService.create(convertToPerson(peopleDTO));
        return ResponseEntity.ok(HttpStatus.OK);
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
    private People convertToPerson(PeopleDTO peopleDTO) {
        return modelMapper.map(peopleDTO, People.class);
    }
    private PeopleDTO convertToPeopleDTO(People people){
        return modelMapper.map(people,PeopleDTO.class);
    }

}
