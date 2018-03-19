package top.imyzt.springboot.advanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.imyzt.springboot.advanced.pojo.User;
import top.imyzt.springboot.advanced.respository.UserRespository;
import top.imyzt.springboot.advanced.service.UserService;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * 用户操作服务类
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRespository userRespository;

    /**
     * 使用@Transactional测试事务,如果第二条数据插入失败.第一条数据也会回滚.不会插入数据库
     * mysql需使用InnoDB数据库引擎
     */
    @Override
    @Transactional
    public void addTwoUser() {
        User u1 = new User();
        User u2 = new User();

        u1.setName("测试1");
        u1.setAddress("测试地址");
        u1.setAge(20);
        u1.setEmail("12121@gamil.com");
        userRespository.save(u1);

        u2.setName("测试2");
        u2.setAddress("测试地址");
        //age为char(4).此时过大,会抛出异常
        u2.setAge(12121);
        u2.setEmail("12132321@gamil.com");

        userRespository.save(u2);
    }

    @Override
    public void getAge(Integer id) throws Exception {
        User user = userRespository.getOne(id);

        Integer age = user.getAge();
        if (age < 10){
            throw new Exception("小于10岁");
        }else if (age >= 10 && age <18){
            throw new Exception("10 <= age < 18");
        }
        throw new Exception("没问题");
    }
}
