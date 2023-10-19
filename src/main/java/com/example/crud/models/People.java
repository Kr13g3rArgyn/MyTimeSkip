package com.example.crud.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "people")
@Data
@NoArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 40, message = "Name should be between 3 and 40 characters")
    private String name;

    @NotNull
    private Boolean alive;

    @NotNull
    @Size(min = 2, max = 20,message = "Species should be between 2 and 20 characters")
    private String species;

    @NotNull
    @Size(min = 2, max = 7, message = "Gender can't be longer than 6 and shorter than 2 characters")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;

    @ManyToOne
    @JoinColumn(name = "voice_id")
    private VoiceActor voiceActor;

    //After DTO
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_who")
    @NotNull
    private String created_who;

}
