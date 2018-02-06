package com.kelechi.andela.hellobooks.controllers;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.service.UsersService;
import com.kelechi.andela.hellobooks.util.response.AuthenticationResponse;
import com.kelechi.andela.hellobooks.util.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public @ResponseBody
    AuthenticationResponse signup(@RequestBody UserDTO userDto){
        AuthenticationResponse signupUserResponse = usersService.signup(userDto);
        return signupUserResponse;
    }

    @RequestMapping(value = "/signin", method= RequestMethod.POST)
    public @ResponseBody
    AuthenticationResponse signin(@RequestBody UserDTO userDto){
        AuthenticationResponse signinResponse = usersService.signin(userDto);
        return signinResponse;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody UsersResponse getAllUsers(@RequestHeader(value = "token") String token){
        UsersResponse usersResponse = usersService.getAllUsers(token);
        return usersResponse;
    }
}
