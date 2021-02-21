

create table if not exists Ingredient(
    id bigint not null primary key,
    naam varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Recept(
    id bigint not null primary key,
    naam varchar(25) not null,
    bereidingstijd int,
    bereiding varchar(225),
    kosten int,
    persoon varchar(25)
);

create table if not exists Recept_Ingredienten(
    recept bigint not null,
    ingredient bigint not null
);

alter table Recept_Ingredienten
    add foreign key (recept) references Recept(id);
alter table Recept_Ingredienten
    add foreign key (ingredient) references Ingredient(id);