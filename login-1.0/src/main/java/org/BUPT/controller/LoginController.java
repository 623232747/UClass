package org.BUPT.controller;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.BUPT.DAO.UserRepository;
import org.BUPT.Result.ResultModel;
import org.BUPT.Result.ResultStatus;
import org.BUPT.authorization.Config.Constants;
import org.BUPT.authorization.annotation.Authorization;
import org.BUPT.authorization.annotation.CurrentUser;
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
public class LoginController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<ResultModel> login(@RequestParam(value = "userID") String userID, @RequestParam(value = "password") String password) {

        Assert.notNull(userID, "username can not be empty");
        Assert.notNull(password, "password can not be empty");


        User user = userRepository.findById(Long.parseLong(userID)).orElse(Constants.defaltUser);
        if (user.getId() != null && user.getPassword().equals(password)) {
            TokenModel token = tokenManager.createToken(user.getId());
            return new ResponseEntity<>(ResultModel.ok(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping ("/register")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<ResultModel> logout(@CurrentUser User user) {

        tokenManager.deleteToken(user.getId());
        System.out.println("delete ok");
        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }


//
//    @PostMapping("/register")
//    public void register(){
//        // 注册模块，前端还要写
//    }

}