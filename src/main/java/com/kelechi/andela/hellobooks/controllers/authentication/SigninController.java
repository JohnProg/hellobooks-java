package com.kelechi.andela.hellobooks.controllers.authentication;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.service.authentication.SigninServiceImpl;
import com.kelechi.andela.hellobooks.util.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SigninController {
    @Autowired
    private SigninServiceImpl signinService;

    @RequestMapping(value = "/api/v1/users/signin", method= RequestMethod.POST)
    public @ResponseBody
    AuthenticationResponse addUser(@RequestBody UserDTO userDto){
        AuthenticationResponse signinResponse = signinService.signinUser(userDto);
        return signinResponse;
    }
}
