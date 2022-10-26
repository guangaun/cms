package com.briup.cms.dao;

import com.briup.cms.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Integer> {
//    User findByName(String username);

    @Query(value = "update cms_user set status = ?2 where id = ?1",nativeQuery = true)
    void updateUserStatus(Integer id, String status);
}
