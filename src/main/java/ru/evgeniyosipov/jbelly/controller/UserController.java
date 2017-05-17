package ru.evgeniyosipov.jbelly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.evgeniyosipov.jbelly.repository.RoleRepository;
import ru.evgeniyosipov.jbelly.repository.UserRepository;

/**
 * Created by Evgeniy Osipov on 17.05.2017.
 */
@Controller
public class UserController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("view", "user/register");
        return "base-layout";
    }
}
