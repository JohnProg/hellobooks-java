package com.kelechi.andela.hellobooks.service.authentication;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.util.response.AuthenticationResponse;

public interface SigninService {
    AuthenticationResponse signinUser(UserDTO userDTO);
}
