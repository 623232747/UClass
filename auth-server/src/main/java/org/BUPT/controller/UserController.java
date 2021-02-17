package org.BUPT.controller;
import org.BUPT.DAO.UserRepository;
import org.BUPT.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@Controller
@Api(value = "用户接口",tags = "用户接口")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //http://localhost:8094/register
    @ApiOperation(value = "用户注册事务")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String addNewUser(@RequestBody User user){
        User u1 = new User();
        u1.setUsername(user.getUsername());
        u1.setPassword(user.getPassword());
        u1.setEmail(user.getEmail());
        u1.setCreateTime(new Date());

        userRepository.save(u1);
        return "Saved";
    }

    //http://localhost:8094/signin
    @ApiOperation(value = "用户登录事务")
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public String loginService(@RequestBody int id,@RequestBody String password){
        return "success";
    }


    //http://localhost:8094/all
    @ApiOperation(value = "获取所有用户")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

}
