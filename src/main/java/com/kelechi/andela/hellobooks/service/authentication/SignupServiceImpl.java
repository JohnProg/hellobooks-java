package com.kelechi.andela.hellobooks.service.authentication;

import com.kelechi.andela.hellobooks.dto.UserDTO;
import com.kelechi.andela.hellobooks.models.Users;
import com.kelechi.andela.hellobooks.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String firstname = userDTO.getFirstname();
        String lastname = userDTO.getLastname();
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        if("".equals(username) || username == null ){
            return "Username is required";
        }
        if(username.length() < 5){
            return "Username is too short";
        }
        if(username.length() > 10){
            return "Username is too long";
        }

        if("".equals(firstname) || firstname == null){
            return "Firstname is required";
        }

        if("".equals(lastname) || lastname == null){
            return "Lastname is required";
        }

        if("".equals(email) || email == null){
            return "Email is required";
        }

        if("".equals(password) || password == null){
            return "Password is required";
        }

        List<Users> existingUsername =  userRepository.findByUsername(username);
        List<Users> existingEmail = userRepository.findByEmail(email);

        if(existingUsername.size() > 0){
            return "Username is already existing";
        }else if(existingEmail.size() > 0){
            return "Email is already existing";
        }else{
            try {
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
                Users user = new Users(firstname, lastname, email, username, hashedPassword);
                userRepository.save(user);
                return "User saved successfully";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
