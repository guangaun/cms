package com.briup.cms.dao;

import com.briup.cms.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);

    @Query(value = "update User u set u.status = :status where u.id = :id")
    @Modifying
    @Transactional

    void updateUserStatus(@Param("id") Integer id,@Param("status") String status);
}
