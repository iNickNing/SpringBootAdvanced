package top.imyzt.springboot.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.imyzt.springboot.app.service.impl.UserServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    //TODO 自动注入失败
    @Test
    public void getAge() throws Exception {
        Integer age = userService.getAge(4);
        System.out.println(age);
    }

}