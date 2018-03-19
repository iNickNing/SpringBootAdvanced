package top.imyzt.springboot.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.imyzt.springboot.app.enums.ResultEnum;
import top.imyzt.springboot.app.exception.AppException;
import top.imyzt.springboot.app.pojo.User;
import top.imyzt.springboot.app.respository.UserRespository;
import top.imyzt.springboot.app.service.UserService;

import javax.transaction.Transactional;

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
    public Integer getAge(Integer id) throws Exception {
        User user = userRespository.getOne(id);

        Integer age = user.getAge();
        if (age < 10){
            throw new AppException(ResultEnum.MIDDLE_SCHOOL);
        }else if (age >= 10 && age <18){
            throw new AppException(ResultEnum.PRIMARY_SCHOOL);
        }

        return user.getAge();
    }

}
