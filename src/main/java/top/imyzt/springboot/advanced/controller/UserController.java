package top.imyzt.springboot.advanced.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.imyzt.springboot.advanced.pojo.Result;
import top.imyzt.springboot.advanced.pojo.User;
import top.imyzt.springboot.advanced.respository.UserRespository;
import top.imyzt.springboot.advanced.service.UserService;
import top.imyzt.springboot.advanced.utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "用户操作")
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户")
    @GetMapping(value = "/user")
    public List<User> list(){
        return userRespository.findAll();
    }

    @ApiOperation(value = "添加一个用户,")
    @PostMapping(value = "/user")
    public Result addUser(@RequestBody @Valid User user, BindingResult bindingResult){
        //通过BindingResult和@Valid对应的实体类属性中注解的条件生成验证规则
        if (bindingResult.hasErrors()){
            return ResultUtil.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.ok(userRespository.save(user));
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

    @ApiOperation(value = "插入两条数据,使用事务管理")
    @PostMapping(value = "/user/addTwoUser")
    public void addTwoUser(){
        userService.addTwoUser();
    }

    @ApiOperation(value = "根据id获取用户年龄")
    @PostMapping(value = "/user/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
        userService.getAge(id);
    }
}
