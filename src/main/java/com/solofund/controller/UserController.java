package com.solofund.controller;

import com.solofund.models.User;
import com.solofund.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getStudents(){
        return  userService.getUsers();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteStudent(@PathVariable("userID") Long id){
        userService.deleteUser(id);
    }


}

