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

    //Ссылка на страницу формы
    @GetMapping("/add-user")
    public String pageAdd() {
        return "add-user";
    }

    //Метод добавления пользователя
    @PostMapping("/add")
    public String saveUser(User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/api/get-users";
    }

    //метод получения всех пользователей
    @GetMapping("/get-users")
    public String getUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "get-user";
    }

    //метод изменения пользователя
    @GetMapping("/update-user")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "redirect:api/get-users";
    }

    //метод удаления пользователя
    @DeleteMapping ("/delete{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:api/get-users";
    }

}
