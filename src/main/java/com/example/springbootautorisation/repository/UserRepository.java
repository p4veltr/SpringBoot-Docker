package com.example.springbootautorisation.repository;

import com.example.springbootautorisation.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<String, String> userData;
    private final ConcurrentHashMap<String, List<Authorities>> userAuthorities;

    public UserRepository() {
        userData = new ConcurrentHashMap<>();
        userAuthorities = new ConcurrentHashMap<>();
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!userData.containsKey(user)) return new ArrayList<>();
        if (!userData.get(user).equals(password)) return new ArrayList<>();
        // user-password correct

        if (!userAuthorities.containsKey(user)) return new ArrayList<>();
        // some Authorities exist

        return userAuthorities.get(user);
    }
}
