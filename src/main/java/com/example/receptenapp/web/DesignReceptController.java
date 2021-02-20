package com.example.receptenapp.web;

import com.example.receptenapp.Ingredient;
import com.example.receptenapp.Ingredient.Type;
import com.example.receptenapp.Recept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@Slf4j
public class DesignReceptController {
    /**
     * private ReceptRepository receptRepo;
     * private UserRepository userRepo;
     * private final IngredientRepository ingredientRepo;
     * <p>
     * public DesignReceptController(IngredientRepository ingredientRepo, UserRepository userRepo, ReceptRepository receptRepo) {
     * this.ingredientRepo = ingredientRepo;
     * this.userRepo = userRepo;
     * this.receptRepo = receptRepo;
     * }
     **/
    @ModelAttribute(name = "design")
    public Recept design() {
        return new Recept();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        log.info("   --- Designing recept");


        /**List<Ingredient> ingredients = new ArrayList<>();
         ingredientRepo.findAll().forEach(i -> ingredients.add(i));

         Ingredient.Type[] types = Ingredient.Type.values();
         for (Type type : types) {
         model.addAttribute(type.toString().toLowerCase(),
         filterByType(ingredients, type));
         }

         String username = principal.getName();
         User user = userRepo.findByUsername(username);
         **/
        model.addAttribute("design", new Recept());

        return "design";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
