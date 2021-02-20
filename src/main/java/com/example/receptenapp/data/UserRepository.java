package com.example.receptenapp.data;

import com.example.receptenapp.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}