package com.apixcloud.users.persistence.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.apixcloud.commons.interfaces.IByNameApi;
import com.apixcloud.users.persistence.models.Privilege;

public interface IPrivilegeJpaDao extends JpaRepository<Privilege, Long>, JpaSpecificationExecutor<Privilege>, IByNameApi<Privilege> {
    //
}
