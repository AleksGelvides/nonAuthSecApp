package com.example.nonauthsecapp.repo;

import com.example.nonauthsecapp.model.User;
import com.example.nonauthsecapp.utils.PasswordUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRepo {
    private final static Map<String, User> USERS = new HashMap<>();

    @PostConstruct
    public void initDB() {
        final String field = "admin";
        USERS.put(field, new User(field, PasswordUtils.hashPass(field)));
    }

    public Optional<User> findUserByUsername(final String userName) {
        return Optional.of(USERS.get(userName));
    }
}
