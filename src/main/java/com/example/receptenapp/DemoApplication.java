package com.example.receptenapp;

import com.example.receptenapp.data.IngredientRepository;
import com.example.receptenapp.data.ReceptRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    static Logger log = LoggerFactory.getLogger("test");

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientenRepo, ReceptRepository receptRepo) {
        /**Ingredient ingr1 = new Ingredient(1, "Olijfolie", Ingredient.Type.OLIE);
         Ingredient ingr2 = new Ingredient(2, "Appelazijn", Ingredient.Type.AZIJN);
         Ingredient ingr3 = new Ingredient(3, "Soya melk", Ingredient.Type.VLOEISTOF);
         Ingredient ingr4 = new Ingredient(4, "Spelt brood", Ingredient.Type.BROOD);
         Ingredient ingr5 = new Ingredient(5, "Ketjap", Ingredient.Type.SAUS);
         Ingredient ingr6 = new Ingredient(6, "Passata", Ingredient.Type.SAUS);
         Ingredient ingr7 = new Ingredient(7, "Bloemkool", Ingredient.Type.GROENTE);
         Ingredient ingr8 = new Ingredient(8, "Broccoli", Ingredient.Type.GROENTE);
         Ingredient ingr9 = new Ingredient(9, "Tomaat", Ingredient.Type.GROENTE);
         Ingredient ingr10 = new Ingredient(10, "Komijn", Ingredient.Type.KRUIDEN);
         Ingredient ingr11 = new Ingredient(11, "Couscous", Ingredient.Type.GRAAN);
         Ingredient ingr12 = new Ingredient(12, "Lasagne", Ingredient.Type.PASTA);
         Ingredient ingr13 = new Ingredient(13, "Gnocchi", Ingredient.Type.PASTA);
         Ingredient ingr14 = new Ingredient(14, "Aardappel", Ingredient.Type.OVERIG);
         List<Ingredient> ingredienten1 = Arrays.asList(ingr4, ingr9);
         List<Ingredient> ingredienten2 = Arrays.asList(ingr6, ingr9, ingr12);
         Recept recept1 = new Recept(1, "hamburgers", 10, "bakken", 8, "Mel");
         recept1.setIngredienten(ingredienten1);
         Recept recept2 = new Recept(2, "lasagne", 10, "oven", 8, "Mel");
         recept2.setIngredienten(ingredienten2);**/
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        };
    }
}
