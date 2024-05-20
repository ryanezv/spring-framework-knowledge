package com.apixcloud.courses.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apixcloud.courses.persistence.daos.IPrivilegeJpaDao;
import com.apixcloud.courses.persistence.models.Privilege;
import com.apixcloud.courses.persistence.models.Role;
import com.apixcloud.courses.services.IPrivilegeService;

@Service
@Transactional
public class PrivilegeService implements IPrivilegeService {

    @Autowired
    private IPrivilegeJpaDao dao;

    @Override
    public Privilege findOne(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<Privilege> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Privilege> findAllSorted(String sortBy, String sortOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSorted'");
    }

    @Override
    public List<Privilege> findAllPaginated(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPaginated'");
    }

    @Override
    public List<Privilege> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPaginatedAndSorted'");
    }

    @Override
    public Privilege create(Privilege resource) {
        return dao.save(resource);
    }

    @Override
    public void update(Privilege resource) {
        dao.save(resource);
    }

    @Override
    public void delete(long id) {
        Optional<Privilege> privilege = dao.findById(id);
        if(privilege.isPresent()){
            dao.delete(privilege.get());
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
