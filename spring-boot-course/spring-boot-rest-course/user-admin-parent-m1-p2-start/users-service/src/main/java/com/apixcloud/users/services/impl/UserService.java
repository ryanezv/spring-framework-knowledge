package com.apixcloud.users.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apixcloud.users.persistence.daos.IUserJpaDao;
import com.apixcloud.users.persistence.models.UserEntity;
import com.apixcloud.users.services.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserJpaDao dao;

    @Override
    public UserEntity findOne(long id) {        
        Optional<UserEntity> entity = dao.findById(id);
        return entity.orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {        
        return dao.findAll();
    }

    @Override
    public UserEntity create(UserEntity resource) {
        final UserEntity entity = dao.save(resource);
        return entity;
    }

    @Override
    public void update(UserEntity resource) {        
        dao.save(resource);
    }

    @Override
    public void delete(long id) {
        Optional<UserEntity> entity = dao.findById(id);
        if(entity.isPresent()){
            dao.delete(entity.get());
        }
    }
    
}
