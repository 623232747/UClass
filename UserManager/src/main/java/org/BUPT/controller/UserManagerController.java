package org.BUPT.controller;

import org.BUPT.DAO.UserRepository;
import org.BUPT.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@Controller

public class UserManagerController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/")
    public User findUserById(@RequestParam(value = "userID") String userID){
        Assert.notNull(userID, "username can not be empty");
        return userRepository.findById(Long.parseLong(userID)).orElse(new User());
    }

}
