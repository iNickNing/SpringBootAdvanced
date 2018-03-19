package top.imyzt.springboot.advanced.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.imyzt.springboot.advanced.pojo.User;
import top.imyzt.springboot.advanced.respository.UserRespository;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "用户操作")
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserRespository userRespository;

    @ApiOperation(value = "获取所有用户")
    @GetMapping(value = "/user")
    public List<User> list(){
        return userRespository.findAll();
    }

    @ApiOperation(value = "添加一个用户")
    @PostMapping(value = "/user")
    public User addUser(@RequestBody User user){
        return userRespository.save(user);
    }

    @ApiOperation(value = "根据id删除一个用户")
    @DeleteMapping(value = "/user/{id}")
    public void delUser(@PathVariable(value = "id") Integer id){
        userRespository.deleteById(id);
    }

    @ApiOperation(value = "修改用户信息")
    @PutMapping(value = "/user")
    public User editUser(@RequestBody User user){
        return userRespository.save(user);
    }

    @ApiOperation(value = "根据id查询用户")
    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id){
        return userRespository.getOne(id);
    }

    @ApiOperation(value = "根据age查询用户")
    @GetMapping(value = "/user/age/{age}")
    public List<User> getUserByAge(@PathVariable(value = "age") Integer age){
        return userRespository.findByAge(age);
    }
}
