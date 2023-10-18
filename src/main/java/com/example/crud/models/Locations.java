package com.example.crud.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "planet_name")
    private String planet_name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "dimension_id")
    private Dimension dimension;

    @OneToMany
    @Column(name = "residents")
    List<People> residents;

    public Locations() {
    }

    public Locations(Long id, String planet_name, String type, List<People> residents) {
        this.id = id;
        this.planet_name = planet_name;
        this.type = type;
        this.residents = residents;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPlanet_name() {
        return planet_name;
    }

    public void setPlanet_name(String planet_name) {
        this.planet_name = planet_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<People> getResidents() {
        return residents;
    }

    public void setResidents(List<People> residents) {
        this.residents = residents;
    }
}
