package com.yinchuan.yunshu.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for user functions
 * @author Siyuan Zeng
 *
 */
@RestController

public class UserController {
    /**
     * Service methods for user functions
     */
    @Autowired
    private UserService userService;

    /**
     * Find All Users Endpoint
     * @return List of Users from UserService method findAll
     */
    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    /**
     * Login Endpoint
     * @param username The inputed string corresponding to the username
     * @param password The inputed string corresponding to the password
     * @return ResponseEntity containing the error message if the credentials are incorrect or the User object if the credentials are correct
     */
    @RequestMapping(method = RequestMethod.POST, path = "/users/login")
    public ResponseEntity<?> authenticate(@RequestParam String username, String password) {
        return userService.authenticate(username, password);
    }

    /**
     * Find User By Id Endpoint
     * @param userId The id of the expected user
     * @return The User from the UserService method findById
     */
    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}")
    public User findById(@PathVariable int userId) {
        return userService.findById(userId);
    }

    /**
     * Create a New User Endpoint
     * @param user A user object containing at least the username and password, and possible the first and/or last name of the new user
     * @return Message from the UserService method createUser
     */
    @RequestMapping(method = RequestMethod.POST, path = "/users/createUser")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }



}
