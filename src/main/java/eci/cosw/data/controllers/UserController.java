package eci.cosw.data.controllers;

import eci.cosw.data.model.User;
import eci.cosw.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
        UserRepository userRepository;

        @GetMapping
        public List<User> getUsers(){
            return userRepository.findAll();
        }

}
