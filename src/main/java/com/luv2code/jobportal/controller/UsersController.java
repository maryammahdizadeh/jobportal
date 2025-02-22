package com.luv2code.jobportal.controller;

import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.service.UsersTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UsersTypeSevice usersTypeSevice;

    @Autowired
    public UsersController(UsersTypeSevice usersTypeSevice) {
        this.usersTypeSevice = usersTypeSevice;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeSevice.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }
}
