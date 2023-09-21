package com.example.crud.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    @NotNull
    @Size(min = 3, max = 40, message = "Name should be between 3 and 40 characters")
    private String name;
    @Column(name = "alive")
    @NotNull
    private Boolean alive;
    @Column(name="species")
    @NotNull
    @Size(min = 2, max = 20,message = "Species should be between 2 and 20 characters")
    private String species;
    @Column(name = "gender")
    @NotNull
    @Size(min = 2, max = 6, message = "Gender can't be longer than 6 and shorter than 2 characters")
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
