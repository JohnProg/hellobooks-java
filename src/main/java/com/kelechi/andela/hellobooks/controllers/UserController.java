package com.kelechi.andela.hellobooks.controllers;

import com.kelechi.andela.hellobooks.models.Users;
import com.kelechi.andela.hellobooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/add")
    public @ResponseBody String addUser(@RequestParam String firstname, @RequestParam String lastname,  @RequestParam String username, @RequestParam String email, @RequestParam String password){

        Users user = new Users();
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setPassword(password);
        user.setUsername(username);
        System.out.println(user);
        userRepository.save(user);
        return "saved";
    }

}
