package com.apixcloud.courses.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.apixcloud.courses.persistence.models.UserEntity;

public interface IUserJpaDao extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>{
}
