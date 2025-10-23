package com.example;

import com.example.repository.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;


@Controller("/users")
@Tag(name = "User")
public class UserController  {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Get("/")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Post("/")
    public HttpResponse<User> createUser(@Body @Valid User user) {
        User savedUser = userRepository.save(user);
        URI location = URI.create("/users/" + savedUser.getId());
        return HttpResponse
                .created(savedUser)
                .headers(headers -> headers.location(location));
    }


}
