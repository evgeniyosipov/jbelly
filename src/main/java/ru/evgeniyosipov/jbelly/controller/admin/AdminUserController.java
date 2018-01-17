package ru.evgeniyosipov.jbelly.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgeniyosipov.jbelly.entity.User;
import ru.evgeniyosipov.jbelly.repository.ArticleRepository;
import ru.evgeniyosipov.jbelly.repository.RoleRepository;
import ru.evgeniyosipov.jbelly.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public String listUsers(Model model){
        List<User> users = this.userRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("view", "admin/user/list");

        return "base-layout";
    }
}
