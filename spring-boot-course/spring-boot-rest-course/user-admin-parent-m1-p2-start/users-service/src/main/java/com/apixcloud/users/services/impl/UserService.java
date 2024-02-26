package com.apixcloud.users.services.impl;

import java.util.List;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<UserEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public UserEntity create(UserEntity resource) {
        final UserEntity entity = dao.save(resource);
        return entity;
    }

    @Override
    public void update(UserEntity resource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
