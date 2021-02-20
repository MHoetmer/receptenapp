package com.example.receptenapp.web;

import com.example.receptenapp.Ingredient;
import com.example.receptenapp.Recept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController("/recept")
public class ReceptController {

    //private ReceptRepository receptRepo;

    /**
     * public ReceptController(ReceptRepository receptRepo) {
     * this.receptRepo = receptRepo;
     * }
     **/

    @GetMapping("/recept/{id}")
    public Recept recept(@PathVariable(value = "id") String id) {
        System.out.println("showRecept " + id);
        Recept stampot = new Recept();
        Ingredient aardappel = new Ingredient(1, "Aardappel", Ingredient.Type.OVERIG);
        ArrayList<Ingredient> ingredienten = new ArrayList<Ingredient>();
        ingredienten.add(aardappel);
        stampot.setNaam("Stampot");
        stampot.setIngredienten(ingredienten);
        return stampot;
    }


}

