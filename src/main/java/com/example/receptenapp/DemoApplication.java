package com.example.receptenapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    static Logger logger = LoggerFactory.getLogger("test");

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**@Bean public CommandLineRunner dataLoader(IngredientRepository repo) {
    return new CommandLineRunner() {
    @Override public void run(String... args) throws Exception {
    repo.save(new Ingredient("BROC", "Broccoli", Type.GROENTE));
    repo.save(new Ingredient("KETJ", "Ketjap", Type.SAUS));
    repo.save(new Ingredient("APAZ", "Appelazijn", Type.AZIJN));
    repo.save(new Ingredient("CSCS", "Couscous", Type.GRAAN));
    repo.save(new Ingredient("KOMI", "Komijn", Type.KRUIDEN));
    repo.save(new Ingredient("LETC", "Kokos olie", Type.OLIE));
    repo.save(new Ingredient("GNOC", "Gnocci", Type.PASTA));
    repo.save(new Ingredient("SPELT", "Spelt brood", Type.BROOD));
    repo.save(new Ingredient("TEMP", "Tempee", Type.OVERIG));
    repo.save(new Ingredient("SOYM", "Soya melk", Type.VLOEISTOF));
    }
    };
    }**/
}
