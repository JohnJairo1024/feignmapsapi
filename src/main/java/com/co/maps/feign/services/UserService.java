package com.co.maps.feign.services;

import com.co.maps.feign.domain.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    User findById(long id);

    List<User> findAll();

    User save(User user);
}
