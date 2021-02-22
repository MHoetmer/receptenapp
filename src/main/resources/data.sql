insert into Ingredient(naam, type) values ("Olijfolie", "OLIE");
insert into Ingredient(naam, type) values ("Appelazijn", "AZIJN");
insert into Ingredient(naam, type) values ("Soya melk", "VLOEISTOF");
insert into Ingredient(naam, type) values ("Spelt brood", "BROOD");
insert into Ingredient(naam, type) values ("Ketjap", "SAUS");
insert into Ingredient(naam, type) values ("Passata", "SAUS");
insert into Ingredient(naam, type) values ("Bloemkool", "GROENTE");
insert into Ingredient(naam, type) values ("Broccoli", "GROENTE");
insert into Ingredient(naam, type) values ("Tomaat", "GROENTE");
insert into Ingredient(naam, type) values ("Komijn", "KRUIDEN");
insert into Ingredient(naam, type) values ("Couscous", "GRAAN");
insert into Ingredient(naam, type) values ("Lasagne", "PASTA");
insert into Ingredient(naam, type) values ("Gnocchi", "PASTA");
insert into Ingredient(naam, type) values ("Aardappel", "OVERIG");

insert into Recept(naam, bereidingstijd, bereiding, kosten, persoon) values ("hamburgers", 10, "bakken", 8, "Mel");
insert into Recept(naam, bereidingstijd, bereiding, kosten, persoon) values ("lasagne", 10, "oven", 8, "Mel");

insert into Recept_Ingredienten(recept, ingredient) values (1,1);
insert into Recept_Ingredienten(recept, ingredient) values (1,4);
insert into Recept_Ingredienten(recept, ingredient) values (1,5);
insert into Recept_Ingredienten(recept, ingredient) values (2,14);
insert into Recept_Ingredienten(recept, ingredient) values (2,9);
insert into Recept_Ingredienten(recept, ingredient) values (2,6);


