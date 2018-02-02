package com.kelechi.andela.hellobooks.service.authentication;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.models.Users;
import com.kelechi.andela.hellobooks.repository.UserRepository;
import com.kelechi.andela.hellobooks.util.helpers.JSONTokenManager;
import com.kelechi.andela.hellobooks.util.response.AuthenticationResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SigninServiceImpl implements SigninService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthenticationResponse signinUser(UserDTO userDTO) {

        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        if("".equals(email) || email == null){
            return new AuthenticationResponse(false, "Email is required");
        }

        if("".equals(password) || password == null){
            return new AuthenticationResponse(false, "Password is required");
        }

        List<Users> existingUserList = userRepository.findByEmail(email);
        if(existingUserList.size() == 0){
            return new AuthenticationResponse(false, "Email or password is incorrect");
        }else{
            Users existingUser = existingUserList.get(0);
            boolean isAuthenticated = checkPassword(password, existingUser.getPassword());
            Long id = existingUser.getId();
            String userEmail = existingUser.getEmail();
            String username = existingUser.getUsername();

            if(isAuthenticated){
                String token = JSONTokenManager.createJWT(id, userEmail, username);
                String message = "User successfully signed in";
                boolean success = true;
                return new AuthenticationResponse(token, success, message, existingUser);
            }
            return new AuthenticationResponse(false, "Email or password is incorrect");
        }
    }

    private boolean checkPassword(String password, String hashedPassword){
        boolean isVerified = false;
        if(BCrypt.checkpw(password, hashedPassword)){
            isVerified = true;
        }
        return  isVerified;
    }

}
