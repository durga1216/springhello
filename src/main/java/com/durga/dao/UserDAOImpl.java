package com.durga.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.durga.dto.User;
import com.durga.util.MyCassandraTemplate;
@Repository("uDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
    private MyCassandraTemplate myCassandraTemplate;
    
    public User createUser(User User) {     
        return myCassandraTemplate.create(User, User.class);
    }
    
    public User getUser(int id) {       
        return myCassandraTemplate.findById(id, User.class);
    }
    
    public User updateUser(User User) {     
        return myCassandraTemplate.update(User, User.class);
    }

    public void deleteUser(int id) {        
        myCassandraTemplate.deleteById(id, User.class);
    }

    public List<User> getAllUsers() {       
        return myCassandraTemplate.findAll(User.class);
    }

}
