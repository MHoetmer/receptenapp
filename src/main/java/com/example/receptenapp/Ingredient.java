package com.example.receptenapp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Naam;
    private ArrayList<Type> Type;


    @RequiredArgsConstructor
    public static enum Type {
        OLIE, AZIJN, VLOEISTOF, BROOD, SAUS, GROENTE, KRUIDEN, GRAAN, PASTA, OVERIG
    }

}
