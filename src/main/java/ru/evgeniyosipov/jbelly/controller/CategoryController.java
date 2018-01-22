package ru.evgeniyosipov.jbelly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgeniyosipov.jbelly.entity.Category;
import ru.evgeniyosipov.jbelly.repository.ArticleRepository;
import ru.evgeniyosipov.jbelly.repository.CategoryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String list(Model model){
        List<Category> categories = this.categoryRepository.findAll();

        categories = categories.stream()
                .sorted(Comparator.comparingInt(Category::getId))
                .collect(Collectors.toList());

        model.addAttribute("view", "admin/category/list");
        model.addAttribute("categories", categories);

        return "base-layout";
    }
}
