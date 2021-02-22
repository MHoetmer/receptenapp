package com.example.receptenapp.web;

import com.example.receptenapp.Recept;
import com.example.receptenapp.data.IngredientRepository;
import com.example.receptenapp.data.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;


@RestController("/recept")
public class ReceptController {

    private final IngredientRepository ingredientRepository;
    private final ReceptRepository receptRepository;

    @Autowired
    public ReceptController(IngredientRepository aIngredientRepository, ReceptRepository aRecepRepository) {
        this.ingredientRepository = aIngredientRepository;
        this.receptRepository = aRecepRepository;
    }

    @GetMapping("/recept/{id}")
    public Recept recept(@PathVariable(value = "id") int id) {
        System.out.println("showRecept " + id);
        Optional<Recept> optionalRecept = receptRepository.findById(id);
        return optionalRecept.isPresent() ?
                optionalRecept.get() : null;
    }

    @GetMapping("/recepten")
    public ArrayList<Recept> recepten() {
        System.out.println("showRecepten");
        ArrayList<Recept> recepten = (ArrayList<Recept>) receptRepository.findAll();
        return recepten;
    }


}

