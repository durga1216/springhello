package com.durga.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.durga.dto.User;

public interface UserService {

	public User createUser(User user);
	public User getUser(int id);
	public User updateUser(User user);
	public void deleteUser(int id);
    public List<User> getAllUsers();

	
}
