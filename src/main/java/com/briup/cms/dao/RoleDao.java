package com.briup.cms.dao;

import com.briup.cms.bean.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
    Page<Role>findAll(Pageable pageable);

    Role findByName(String RoleName);

}
