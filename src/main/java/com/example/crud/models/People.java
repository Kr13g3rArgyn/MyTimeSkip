package com.example.crud.models;
import jakarta.persistence.*;
@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "alive")
    private Boolean alive;
    @Column(name="species")
    private String species;
    @Column(name = "gender")
    private String gender;
    public People(){
    }
    public People(int id, String name, Boolean alive, String species, String gender) {
        this.id = id;
        this.name = name;
        this.alive = alive;
        this.species = species;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getAlive() {
        return alive;
    }
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
