package com.example.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "voice_actors")
public class VoiceActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    private People people;

    public VoiceActor() {
    }

    public VoiceActor(Long id, String name, People people) {
        this.id = id;
        this.name = name;
        this.people = people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}

