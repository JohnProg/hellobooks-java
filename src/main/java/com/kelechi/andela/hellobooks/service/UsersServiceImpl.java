package com.kelechi.andela.hellobooks.service;

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
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthenticationResponse signup(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String firstname = userDTO.getFirstname();
        String lastname = userDTO.getLastname();
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        if("".equals(username) || username == null ){
            String message = "Username is required";
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }
        if(username.length() < 5){
            String message = "Username is too short";
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }
        if(username.length() > 10){
            String message = "Username is too long";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }

        if("".equals(firstname) || firstname == null){
            String message = "Firstname is required";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }

        if("".equals(lastname) || lastname == null){
            String message = "Lastname is required";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }

        if("".equals(email) || email == null){
            String message = "Email is required";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }

        if("".equals(password) || password == null){
            String message = "Password is required";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }

        List<Users> existingUsername =  userRepository.findByUsername(username);
        List<Users> existingEmail = userRepository.findByEmail(email);

        if(existingUsername.size() > 0){
            String message = "Username is already existing";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }else if(existingEmail.size() > 0){
            String message = "Email is already existing";;
            boolean success = false;
            return  new AuthenticationResponse(success, message);
        }else{
            try {
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
                Users user = new Users(firstname, lastname, email, username, hashedPassword);
                Users savedUser =  userRepository.save(user);
                Long id = savedUser.getId();

                String token = JSONTokenManager.createJWT(id, email, username);

                String message = "User saved successfully";
                boolean success = true;

                return new AuthenticationResponse(token, success, message, savedUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public AuthenticationResponse signin(UserDTO userDTO) {

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
