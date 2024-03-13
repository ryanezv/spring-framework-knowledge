package com.apixcloud.umusers.persistence.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apixcloud.umusers.persistence.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
public List<User> findByUsername(String username);
}
