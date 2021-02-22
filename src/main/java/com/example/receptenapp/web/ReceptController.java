package com.example.receptenapp.web;

import com.example.receptenapp.Recept;
import com.example.receptenapp.data.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController("/recept")
public class ReceptController {

    private final ReceptRepository receptRepository;

    @Autowired
    public ReceptController(ReceptRepository aRecepRepository) {
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

    //TODO: save Ingredients
    @PostMapping("/saverecept")
    public Recept saveRecept(@RequestBody Recept recept) {
        System.out.println("saveRecept " + recept.getNaam() + " id ");
        Recept savedRecept = receptRepository.save(recept);
        return savedRecept;
    }


}

