package com.example.receptenapp.web;

import com.example.receptenapp.Ingredient;
import com.example.receptenapp.Recept;
import com.example.receptenapp.data.IngredientRepository;
import com.example.receptenapp.data.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController("/recept")
public class ReceptController {

    private final ReceptRepository receptRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ReceptController(ReceptRepository aRecepRepository, IngredientRepository aIngredientRepository) {
        this.receptRepository = aRecepRepository;
        this.ingredientRepository = aIngredientRepository;
    }

    @GetMapping("/recept/{id}")
    public Recept recept(@PathVariable(value = "id") int id) {
        System.out.println("showRecept " + id);
        Optional<Recept> optionalRecept = receptRepository.findById(id);
        System.out.println("showRecept " + " " + optionalRecept.get());
        return optionalRecept.isPresent() ?
                optionalRecept.get() : null;
    }

    @GetMapping("/recepten")
    public ArrayList<Recept> recepten() {
        System.out.println("showRecepten");
        ArrayList<Recept> recepten = (ArrayList<Recept>) receptRepository.findAll();
        return recepten;
    }

    //TODO: save Ingredients
    //curl -X POST --header "Content-Type: application/json" --data '{"naam":"bloemkool salade", "bereidingstijd":"100", "ingredienten":[{"id":2,"naam":"bloemkool"},{"id":44,"naam":"granaatappel"}]}' localhost:8080/saverecept | jq
    @PostMapping("/saverecept")
    public Recept saveRecept(@RequestBody Recept recept) {
        System.out.println("saveRecept " + recept.getNaam() + " id " + recept.getIngredienten());
        System.out.println("recept.getIngredienten() " + recept.getIngredienten());
        Recept savedRecept = receptRepository.save(recept);
        List<Ingredient> ingredienten = recept.getIngredienten();
        System.out.println("saved " + recept.getIngredienten());
        for (Ingredient i : ingredienten) {
            ingredientRepository.save(i);
        }
        return savedRecept;
    }
}

