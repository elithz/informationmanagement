package com.yinchuan.yunshu.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.query.Param;

/**
 * Interface for accessing user table
 * @author Siyuan Zeng
 *
 */

public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Gets the user from the table by username
     * @param username The username of the user
     * @return User object
     */
    User findByUsername(String username);

    /**
     * Gets user from the table by id
     * @param userId The id of the user
     * @return User object
     */
    User findById(int userId);

    /**
     * Gets all users from the table
     */
    List<User> findAll();
}
