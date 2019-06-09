package com.yinchuan.yunshu.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Methods for user functions
 *
 * @author Siyuan Zeng
 *
 */
@Service
public class UserService {
    /**
     * Interface for connecting to user table
     */
    @Autowired
    private UserRepository users;

    /**
     * Get all users in the user table
     *
     * @return The List of Users from the UserRepository method findAll
     */
    public List<User> findAll() {
        return users.findAll();
    }

    /**
     * Login method
     *
     * @param username
     *            The inputed string corresponding to the username
     * @param password
     *            The inputed string corresponding to the password
     * @return Response Entity containing message if username and/or password are
     *         incorrect. If username is null returns the message "Username cannot
     *         be empty". If the password is null returns the message "Password
     *         cannot be empty". If the username is invalid returns the message
     *         "User does not exist". If the user is banned returns the message "You
     *         are banned". If the password is incorrect returns "Incorrect
     *         Password". Otherwise returns the User object.
     */
    public ResponseEntity<?> authenticate(String username, String password) {
        if (username == null) {
            return new ResponseEntity<>("Username cannot be empty", HttpStatus.BAD_REQUEST);
        }
        if (password == null) {
            return new ResponseEntity<>("Password cannot be empty", HttpStatus.BAD_REQUEST);
        }
        User user = users.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
        }
        if (!user.getPassword().equals(password)) {
            return new ResponseEntity<>("Incorrect Password", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    /**
     * Returns the user with the provided id
     *
     * @param id
     *            The id of the expected user
     * @return The User from the UserRepository method findById
     */
    public User findById(int id) {
        return users.findById(id);
    }

    /**
     * Creates a new user and saves them to the database
     *
     * @param user
     *            A user object containing at least the username and password, and
     *            possible the first and/or last name of the new user
     * @return If the user object is null returns "User cannot be null". If the
     *         username of the user object is null returns "Username cannot be
     *         null". If the password of the user object is null returns "Password
     *         cannot be null". If the password does not meet the password
     *         requirements returns "Password must be 8 characters or longer
     *         Password must contain at least one uppercase Password must contain at
     *         least one lowercase level". If the username is the save as the
     *         username of another user returns "Username taken". Otherwise returns
     *         "User {username} created".
     */
    public String createUser(User user) {
        if (user == null) {
            return "User cannot be null";
        }
        if (user.getUsername() == null) {
            return "Username cannot be null";
        }
        if (user.getPassword() == null) {
            return "Password cannot be null";
        }

        if (users.findByUsername(user.getUsername()) != null) {
            return "Username taken";
        }
        this.users.save(user);
        return "User " + user.getUsername() + " created";
    }
}
