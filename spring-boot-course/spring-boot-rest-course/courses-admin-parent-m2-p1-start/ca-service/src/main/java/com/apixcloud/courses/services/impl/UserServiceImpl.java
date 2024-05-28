package com.apixcloud.courses.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apixcloud.commons.persistence.service.AbstractService;
import com.apixcloud.courses.persistence.daos.IUserJpaDao;
import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IUserService;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserJpaDao dao;    

    public UserServiceImpl() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAllPaginatedRaw(final int page, final int size) {
        final Page<User> userPage = getDao().findAll(PageRequest.of(page, size));        
        return userPage;
    }
    // find

    @Override
    @Transactional(readOnly = true)
    public User findByName(final String name) {
        return dao.findByName(name);
    }

    // Spring

    @Override
    protected final IUserJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
        return dao;
    }
}
