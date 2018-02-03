package com.kelechi.andela.hellobooks.service;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.util.response.AuthenticationResponse;

import java.util.Map;

public interface UsersService {
    AuthenticationResponse signup(UserDTO userDTO);
    AuthenticationResponse signin(UserDTO userDTO);
}
