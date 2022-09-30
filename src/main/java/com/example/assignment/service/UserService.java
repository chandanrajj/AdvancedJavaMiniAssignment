package com.example.assignment.service;

import com.example.assignment.util.ResourceNotFoundException;
import com.example.assignment.model.User;
import com.example.assignment.repository.AddressRepository;
import com.example.assignment.repository.UserRepositoty;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UserService {

    private UserRepositoty userRepositoty;
    private AddressRepository addressRepository;

    public UserService(UserRepositoty userRepositoty, AddressRepository addressRepository) {
        this.userRepositoty = userRepositoty;
        this.addressRepository = addressRepository;
    }

    public User saveUser(User user) {
        User savedUser = userRepositoty.save(user);
        log.info("User with id: " + savedUser.getId() + " saved to DB.");
        return savedUser;
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepositoty.findById(id);
        if(optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User not found for id: " + id);
        }
        return optionalUser.get();
    }
}
