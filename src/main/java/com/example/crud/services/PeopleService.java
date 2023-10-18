package com.example.crud.services;

import com.example.crud.models.People;
import com.example.crud.repository.PeopleRepository;
import com.example.crud.util.PersonNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional()
public class PeopleService {
    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public List<People> findAll(){
        return peopleRepository.findAll();
    }
    public People findOne(int id){
        Optional<People> foundDude = peopleRepository.findById(id);
        return foundDude.orElseThrow(PersonNotFoundException::new);
    }
    @Transactional
    public People create(People people){
        enrichPerson(people);
        return peopleRepository.save(people);
    }
    public People updatePeople(int id, People updatedPeople) {
        Optional<People> existingPeople = peopleRepository.findById(id);
        if (existingPeople.isPresent()) {
            People personToUpdate = existingPeople.get();
            personToUpdate.setName(updatedPeople.getName());
            personToUpdate.setAlive(updatedPeople.getAlive());
            personToUpdate.setSpecies(updatedPeople.getSpecies());
            personToUpdate.setGender(updatedPeople.getGender());
            return peopleRepository.save(personToUpdate);
        } else {
            return null;
        }
    }
    public void deletePeople(int id){
        peopleRepository.deleteById(id);
    }

    private void enrichPerson(People people){
        people.setCreatedAt(LocalDateTime.now());
        people.setUpdatedAt(LocalDateTime.now());
        people.setCreated_who("Rich");
    }

}
