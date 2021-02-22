package com.example.receptenapp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingredient {

    @Id
    private final String Id;
    private final String Naam;
    private final Type Type;

    @RequiredArgsConstructor
    public static enum Type {
        OLIE, AZIJN, VLOEISTOF, BROOD, SAUS, GROENTE, KRUIDEN, GRAAN, PASTA, OVERIG
    }
}
