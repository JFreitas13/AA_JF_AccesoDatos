package com.svalero.books.service;

import com.svalero.books.domain.User;
import com.svalero.books.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    User addUser(User user);
    void deleteUser(long id) throws UserNotFoundException;
    User modifyUser(long id, User newUser) throws UserNotFoundException;
    List<User> findAll();
    User findById(long id) throws UserNotFoundException;

}
