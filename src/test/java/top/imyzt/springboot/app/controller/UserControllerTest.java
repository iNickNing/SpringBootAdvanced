package top.imyzt.springboot.app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void listTest(){
        System.out.println(controller.list());
    }

    @Autowired
    private MockMvc mvc;

    @Test
    public void list() throws Exception {

        /**
         * 通过MockMvc,实现API测试
         * MockMvcRequestBuilders.get("/user/user") 通过Get方法访问url
         * andExpect(MockMvcResultMatchers.status().isOk()); 是否返回ok
         * andExpect(MockMvcResultMatchers.content().string("abc"));  是否返回的是"abc"
         */
        mvc.perform(MockMvcRequestBuilders.get("/user/user"))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().string("abc"));

    }

}