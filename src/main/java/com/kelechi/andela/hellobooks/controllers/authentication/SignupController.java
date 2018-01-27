package com.kelechi.andela.hellobooks.controllers.authentication;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.service.authentication.SignupServiceImpl;
import com.kelechi.andela.hellobooks.util.EndpointResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignupController {
    @Autowired
    private SignupServiceImpl userService;

    @RequestMapping(value = "/api/v1/users/signup", method= RequestMethod.POST)
    public @ResponseBody
    EndpointResponse addUser(@RequestBody UserDTO userDto){
        String saveUserResponse = userService.saveUser(userDto);
        EndpointResponse endpointResponse = new EndpointResponse(saveUserResponse);
        return endpointResponse;
    }
}
