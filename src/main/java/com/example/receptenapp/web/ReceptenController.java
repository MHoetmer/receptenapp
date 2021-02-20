package com.example.receptenapp.web;

import com.example.receptenapp.Ingredient;
import com.example.receptenapp.Recept;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController("/recepten")
public class ReceptenController {

    @GetMapping("/recepten")
    public ArrayList<Recept> showRecepten(Model model) {
        System.out.println("showRecepten");
        ArrayList<Recept> recepten = new ArrayList<Recept>();
        Recept stampot = new Recept();
        Ingredient aardappel = new Ingredient(1, "Aardappel", Ingredient.Type.OVERIG);
        ArrayList<Ingredient> ingredienten = new ArrayList<Ingredient>();
        ingredienten.add(aardappel);
        stampot.setNaam("Stampot");
        stampot.setIngredienten(ingredienten);
        recepten.add(stampot);
        return recepten;
    }


}
