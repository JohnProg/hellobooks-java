package com.kelechi.andela.hellobooks.service.authentication;

import com.kelechi.andela.hellobooks.dto.UserDTO;

import java.util.Map;

public interface SignupService {
    String saveUser(UserDTO userDTO);
}
