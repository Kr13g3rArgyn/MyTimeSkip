package com.example.crud.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "dimension")
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimension_id")
    private int dimension_id;

    @Column(name = "dimension_name")
    private String dimension_name;

    @OneToMany(mappedBy = "dimension")
    private List<Locations> locations;
    public Dimension() {

    }
    public Dimension(int dimensionId, String dimensionName, List<Locations> locations) {
        dimension_id = dimensionId;
        dimension_name = dimensionName;
        this.locations = locations;
    }

    public int getDimension_id() {
        return dimension_id;
    }

    public void setDimension_id(int dimension_id) {
        this.dimension_id = dimension_id;
    }

    public String getDimension_name() {
        return dimension_name;
    }

    public void setDimension_name(String dimension_name) {
        this.dimension_name = dimension_name;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }
}
