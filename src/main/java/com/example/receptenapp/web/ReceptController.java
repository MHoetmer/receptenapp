package com.example.receptenapp.web;

import com.example.receptenapp.Recept;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recept")
public class ReceptController {
git
    //private ReceptRepository receptRepo;

    /**
     * public ReceptController(ReceptRepository receptRepo) {
     * this.receptRepo = receptRepo;
     * }it
     **/

    @GetMapping
    public String showRecept(Model model) {
        model.addAttribute("recept", new Recept());
        return "recept";
    }


}

