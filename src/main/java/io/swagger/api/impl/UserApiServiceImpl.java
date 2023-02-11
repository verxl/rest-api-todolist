package io.swagger.api.impl;

import io.swagger.api.UserApi;
import io.swagger.model.User;

import java.util.List;


/**
 * TodoList
 *
 * <p>Simple TodoList App created with the help of Swagger Editor
 *
 */
public class UserApiServiceImpl implements UserApi {
    private List<User> currentUsers;

    /**
     * Create user
     *
     * This can only be done by the logged in user.
     *
     */
    public User createUser(User user) {
        return user;
    }
    
    /**
     * Creates list of users with given input array
     *
     * Creates list of users with given input array
     *
     */
    public User createUsersWithListInput(List<User> users) {
        return null;
    }
    
    /**
     * Delete user
     *
     * This can only be done by the logged in user.
     *
     */
    public void deleteUser(String username) {
        User user = getUserByName(username);
        user.setId(null);
        user.setEmail(null);
        user.setFirstName(null);
        user.setLastName(null);
        user.setUsername(null);
        user.setPassword(null);
    }
    
    /**
     * Get user by user name
     *
     */
    public User getUserByName(String username) {
        User result = null;
        for (User user: currentUsers) {
            if (user.getUsername() == username) {
                result = user;
            }
        }
        return result;
    }
    
    /**
     * Logs user into the system
     *
     */
    public String loginUser(String username, String password) {
        User user = getUserByName(username);
        if (user.getPassword() == password) {
            return "200";
        } else {
            return "400";
        }
    }
    
    /**
     * Logs out current logged in user session
     *
     */
    public void logoutUser() {
        // TODO: Implement...

    }
    
    /**
     * Update user
     *
     * This can only be done by the logged in user.
     *
     */
    public void updateUser(String username, User body) {
        getUserByName(username);
        // TODO: update the field that needs to be updated
    }
    
}

