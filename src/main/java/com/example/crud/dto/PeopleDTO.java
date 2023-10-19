package com.example.crud.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PeopleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 40, message = "Name should be between 3 and 40 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "alive")
    private Boolean alive;

    @NotNull
    @Size(min = 2, max = 20,message = "Species should be between 2 and 20 characters")
    @Column(name = "species")
    private String species;

    @NotNull
    @Size(min = 2, max = 6, message = "Gender can't be longer than 6 and shorter than 2 characters")
    @Column(name = "gender")
    private String gender;
}
