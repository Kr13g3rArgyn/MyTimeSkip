package com.example.crud.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String planetName;

    private String type;

    @ManyToOne
    @JoinColumn(name = "dimension_id")
    private Dimension dimension;



}
