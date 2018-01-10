package ru.evgeniyosipov.jbelly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.evgeniyosipov.jbelly.entity.Article;
import ru.evgeniyosipov.jbelly.repository.ArticleRepository;

import java.util.List;

/**
 * Created by Evgeniy Osipov on 17.05.2017.
 */
@Controller
public class HomeController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Article> articles = this.articleRepository.findAll();

        model.addAttribute("view", "home/index");
        model.addAttribute("articles", articles);

        return "base-layout";
    }
}
