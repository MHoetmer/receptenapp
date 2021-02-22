package com.example.receptenapp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Naam;
    private int Bereidingstijd;

    @ManyToMany(targetEntity = Ingredient.class)
    private List<Ingredient> Ingredienten;
    private String Bereiding;
    private int Kosten;
    private String Persoon;

}
