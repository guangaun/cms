package com.briup.cms;

import com.briup.cms.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserDao dao;


    @Test
    public void test(){
        dao.updateUserStatus(1,"1");
    }
}
