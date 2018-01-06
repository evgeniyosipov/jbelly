package ru.evgeniyosipov.jbelly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.evgeniyosipov.jbelly.repository.ArticleRepository;
import ru.evgeniyosipov.jbelly.repository.UserRepository;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
}
