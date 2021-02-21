delete from Ingredient;
delete from Recept;
delete from Recept_Ingredienten;

insert into Ingredient(id, naam, type) values (1, "Olijfolie", "OLIE");
insert into Ingredient(id, naam, type) values (2, "Appelazijn", "AZIJN");
insert into Ingredient(id, naam, type) values (3, "Soya melk", "VLOEISTOF");
insert into Ingredient(id, naam, type) values (4, "Spelt brood", "BROOD");
insert into Ingredient(id, naam, type) values (5, "Ketjap", "SAUS");
insert into Ingredient(id, naam, type) values (6, "Bloemkool", "GROENTE");
insert into Ingredient(id, naam, type) values (7, "Broccoli", "GROENTE");
insert into Ingredient(id, naam, type) values (8, "Komijn", "KRUIDEN");
insert into Ingredient(id, naam, type) values (9, "Couscous", "GRAAN");
insert into Ingredient(id, naam, type) values (10, "Lasagne", "PASTA");
insert into Ingredient(id, naam, type) values (11, "Gnocchi", "PASTA");
insert into Ingredient(id, naam, type) values (12, "Aardappel", "OVERIG");

insert into Recept(id, naam, bereidingstijd, bereiding, kosten, persoon) values (1, "hamburgers", 10, "bakken", 8, "Mel");

insert into Recept_Ingredienten(recept, ingredient) values (1,1);

