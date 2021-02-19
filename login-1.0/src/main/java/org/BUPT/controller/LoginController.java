package org.BUPT.controller;
//import org.BUPT.DAO.UserRepository;
import org.BUPT.authorization.manager.TokenManager;
import org.BUPT.authorization.model.TokenModel;
import org.BUPT.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController{

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @Autowired
    private TokenManager tokenManager;
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value="username") String username,@RequestParam(value="password") String password){

        Assert.notNull(username,"username can not be empty");
        Assert.notNull(password,"password can not be empty");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(username+""+password);
        user.setId(1212);
//        TokenModel token = tokenManager.createToken(user.getId());
//        System.out.println(token.getToken());
        return "yes";
    }
//
//    @PostMapping("/register")
//    public void register(){
//        // 注册模块，前端还要写
//    }

}
