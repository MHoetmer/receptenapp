package com.example.receptenapp.data;

import com.example.receptenapp.Recept;
import org.springframework.data.repository.CrudRepository;

public interface ReceptRepository extends CrudRepository<Recept, Long> {

}
