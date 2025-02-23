package com.luv2code.jobportal.controller;

import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.service.UsersService;
import com.luv2code.jobportal.service.UsersTypeSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    private final UsersTypeSevice usersTypeSevice;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeSevice usersTypeSevice, UsersService usersService) {
        this.usersTypeSevice = usersTypeSevice;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeSevice.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model) {
        Optional<Users> optionalUsers = usersService.getByUserEmail(users.getEmail());
        if (optionalUsers.isPresent()) {
            model.addAttribute("error", "Email already registered, try to login or register with another email.");
            List<UsersType> usersTypes = usersTypeSevice.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(users);
        return "dashboard";
    }
}
