package com.durga.dao;

import java.util.List;

import com.durga.dto.User;

public interface UserDAO {
    public User createUser(User User);
    
    /**
     * Getting the User Information using Id
     * @param id
     * @return {@link User}
     */
    public User getUser(int id);
    
    /**
     * Used to Update the User Information
     * @param User
     * @return {@link User}
     */
    
    public User updateUser(User User);
    
    /**
     * Deleting the User Information using Id
     * @param id
     */
    public void deleteUser(int id);
    
    /**
     * Getting the All Users information
     * @return
     */
    public List<User> getAllUsers();

}
