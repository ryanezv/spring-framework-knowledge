package com.apixcloud.users.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.apixcloud.commons.interfaces.IByNameApi;
import com.apixcloud.users.persistence.models.User;

public interface IUserJpaDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, IByNameApi<User> {
    //
}