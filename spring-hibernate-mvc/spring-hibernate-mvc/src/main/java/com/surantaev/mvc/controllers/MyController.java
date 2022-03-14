package com.surantaev.mvc.controllers;

import com.surantaev.mvc.model.Car;
import com.surantaev.mvc.model.User;
import com.surantaev.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MyController {


    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add-user")
    public String pageAdd() {
        return "add-user";
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/get-users")
    public String getUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "get-user";
    }


    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "redirect:/api/get-users";
    }

}
