package com.example.receptenapp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
public class Recept {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private final int Id;
    private final String Naam;
    private final int Bereidingstijd;

    @ManyToMany(targetEntity = Ingredient.class)
    private List<Ingredient> Ingredienten;
    private final String Bereiding;
    private final int Kosten;
    private final String Persoon;

}
