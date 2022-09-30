package com.example.assignment.controller;

import com.example.assignment.model.User;
import com.example.assignment.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(
            @PathVariable
            @Positive(message = "Path variable id should be a positive value")
            Long id
    ) {
        return userService.getUserById(id);
    }
}
