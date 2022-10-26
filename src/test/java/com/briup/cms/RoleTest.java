package com.briup.cms;

import com.briup.cms.utils.Result;
import com.briup.cms.web.controller.RoleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

    @Autowired
    private RoleController roleController;

    @Test
    public void test(){
        System.out.println("11111");
        Result result = roleController.findByPage(0, 2);
        System.out.println(result.getData());

    }
}
