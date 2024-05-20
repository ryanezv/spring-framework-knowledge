package com.apixcloud.courses.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apixcloud.courses.persistence.daos.IRoleJpaDao;
import com.apixcloud.courses.persistence.models.Role;
import com.apixcloud.courses.services.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private IRoleJpaDao roleDao;

    @Override
    public Role findOne(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public List<Role> findAllSorted(String sortBy, String sortOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSorted'");
    }

    @Override
    public List<Role> findAllPaginated(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPaginated'");
    }

    @Override
    public List<Role> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPaginatedAndSorted'");
    }

    @Override
    public Role create(Role resource) {
        return roleDao.save(resource);
    }

    @Override
    public void update(Role resource) {
        roleDao.save(resource);
    }

    @Override
    public void delete(long id) {
        Optional<Role> role = roleDao.findById(id);
        if(role.isPresent()){
            roleDao.delete(role.get());
        }
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }
    
}
