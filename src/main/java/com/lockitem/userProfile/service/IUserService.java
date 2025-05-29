package com.lockitem.userProfile.service;

import com.lockitem.userProfile.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    User createUser(User user);
    Optional<User> findByEmailAndPassword(String email, String password);
}
