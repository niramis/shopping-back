package com.shop.controllers;

import com.shop.model.DAOUser;
import com.shop.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping(produces = "application/json")
    public List<DAOUser> getAllUsers() {
        return (List<DAOUser>) userDao.findAll();
    }

    @GetMapping(produces = "application/json", path = "/find/{name}")
    public List<DAOUser> getUsersByName(@PathVariable("name") String name) {
        return userDao.findUsersByUsername(name);
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    public DAOUser getUsersById(@PathVariable("id") long id) {
        return userDao.findById(id).get();
    }
}
