package com.example.receptenapp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String Naam;

    private Date Aangemaakt;

    private int BereindsTijd;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> Ingredienten;

    private String Bereiding;

    private int Kosten;

    private String Persoon;

}
