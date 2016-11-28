package com.durga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.durga.dao.UserDAO;
import com.durga.dto.User;
@Service("uService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO uDAO;
    
    public UserServiceImpl() {
        super();    
    }
    @Transactional
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return uDAO.createUser(user);
	}
    
    @Transactional
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return uDAO.getUser(id);
	}

    @Transactional
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return uDAO.updateUser(user);
	}
    
    @Transactional
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
    	 uDAO.deleteUser(id);
		
	}
    
    @Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return uDAO.getAllUsers();
	}

}
