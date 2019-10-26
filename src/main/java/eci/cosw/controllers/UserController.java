package eci.cosw.controllers;


import eci.cosw.data.model.User;
import eci.cosw.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}
