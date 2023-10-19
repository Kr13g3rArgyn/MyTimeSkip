package com.example.crud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "dimension")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dimension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dimensionId;

    private String dimensionName;

    @OneToMany(mappedBy = "dimension")
    private List<Locations> locations;

}
