package com.apixcloud.users.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.apixcloud.users.persistence.models.UserEntity;

public interface IUserJpaDao extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>{    
}