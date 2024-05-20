package com.apixcloud.courses.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apixcloud.courses.persistence.daos.IUserJpaDao;
import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
    
    @Autowired
    private IUserJpaDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User create(User resource) {
        return userDao.save(resource);
    }

    @Override
    public void update(User resource) {
        userDao.save(resource);
    }

    @Override
    public void delete(long id) {
        Optional<User> user = userDao.findById(id);
        if(user.isPresent()){
            userDao.delete(user.get());
        }        
    }    
}
