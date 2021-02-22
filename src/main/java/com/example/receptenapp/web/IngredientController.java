package com.example.receptenapp.web;

import com.example.receptenapp.Ingredient;
import com.example.receptenapp.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository aIngredientRepository) {
        this.ingredientRepository = aIngredientRepository;
    }

    @GetMapping("/ingredient/{id}")
    public Ingredient recept(@PathVariable(value = "id") int id) {
        System.out.println("showIngredient " + id);
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        return optionalIngredient.isPresent() ?
                optionalIngredient.get() : null;
    }

    @GetMapping("/ingredienten")
    public ArrayList<Ingredient> ingredienten() {
        System.out.println("showIngredienten");
        ArrayList<Ingredient> ingredienten = (ArrayList<Ingredient>) ingredientRepository.findAll();
        return ingredienten;
    }

    @PostMapping("/saveingredient")
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("saveIngredient " + ingredient.getNaam() + " id ");
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return savedIngredient;
    }
}
