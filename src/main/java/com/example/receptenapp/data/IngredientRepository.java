package com.example.receptenapp.data;


import com.example.receptenapp.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Ingredient findOne(int id);

    Ingredient save(Ingredient ingredient);

}