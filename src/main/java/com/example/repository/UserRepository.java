package com.example.repository;

import com.example.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;


@Repository
public interface UserRepository {

    public List<User> findAll();

    User save(User user);

}

