package com.example.receptenapp.data;


import com.example.receptenapp.Recept;

public interface ReceptRepository {
    Iterable<Recept> findAll();

    Recept findOne(int id);

    Recept save(Recept ingredient);

}