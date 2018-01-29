package com.kelechi.andela.hellobooks.repository;

import com.kelechi.andela.hellobooks.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    List<Users> findByUsername(String username);
    List<Users> findByEmail(String email);
}