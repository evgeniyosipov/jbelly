package ru.evgeniyosipov.jbelly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.evgeniyosipov.jbelly.bindingModel.ArticleBindingModel;
import ru.evgeniyosipov.jbelly.entity.Article;
import ru.evgeniyosipov.jbelly.entity.Category;
import ru.evgeniyosipov.jbelly.entity.Tag;
import ru.evgeniyosipov.jbelly.entity.User;
import ru.evgeniyosipov.jbelly.repository.ArticleRepository;
import ru.evgeniyosipov.jbelly.repository.CategoryRepository;
import ru.evgeniyosipov.jbelly.repository.TagRepository;
import ru.evgeniyosipov.jbelly.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model) {
        List<Category> categories = this.categoryRepository.findAll();
        model.addAttribute("view", "article/create");
        model.addAttribute("categories", categories);
        return "base-layout";
    }

    @GetMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String edit(@PathVariable Integer id, Model model) {
        if (!this.articleRepository.existsById(id)) {
            return "redirect:/";
        }
        Article article = this.articleRepository.findById(id).orElse(null);
        if (!isUserAuthorOrAdmin(article)) {
            return "redirect:/article/" + id;
        }
        List<Category> categories = this.categoryRepository.findAll();
        String tagString = article.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.joining(", "));
        model.addAttribute("view", "article/edit");
        model.addAttribute("article", article);
        model.addAttribute("categories", categories);
        model.addAttribute("tags", tagString);
        return "base-layout";
    }

    @GetMapping("/article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String delete(@PathVariable Integer id, Model model) {
        if (!this.articleRepository.existsById(id)) {
            return "redirect:/";
        }
        Article article = this.articleRepository.findById(id).orElse(null);
        if (!isUserAuthorOrAdmin(article)) {
            return "redirect:/article/" + id;
        }
        model.addAttribute("view", "article/delete");
        model.addAttribute("article", article);
        return "base-layout";
    }

    @GetMapping("/article/{id}")
    public String details(Model model, @PathVariable Integer id) {
        List<Category> categories = this.categoryRepository.findAll();
        List<Tag> tags = this.tagRepository.findAll();
        if (!this.articleRepository.existsById(id)) {
            return "redirect:/";
        }
        if (!(SecurityContextHolder.getContext().getAuthentication()
                instanceof AnonymousAuthenticationToken)) {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal();
            User entityUser = this.userRepository.findByEmail(principal.getUsername());
            model.addAttribute("user", entityUser);
        }
        Article article = this.articleRepository.findById(id).orElse(null);
        model.addAttribute("view", "article/details");
        model.addAttribute("article", article);
        model.addAttribute("categories", categories);
        model.addAttribute("tags", tags);
        return "base-layout";
    }

    private HashSet<Tag> findTagsFromString(String tagString) {
        HashSet<Tag> tags = new HashSet<>();
        String[] tagNames = tagString.split(",\\s*");
        for (String tagName : tagNames) {
            Tag currentTag = this.tagRepository.findByName(tagName);
            if (currentTag == null) {
                currentTag = new Tag(tagName);
                this.tagRepository.saveAndFlush(currentTag);
            }
            tags.add(currentTag);
        }
        return tags;
    }

    @PostMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String createProcess(ArticleBindingModel articleBindingModel) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User userEntity = this.userRepository.findByEmail(user.getUsername());
        Category category = this.categoryRepository.findById(articleBindingModel.getCategoryId()).orElse(null);
        HashSet<Tag> tags = this.findTagsFromString(articleBindingModel.getTagString());
        Article articleEntity = new Article(
                articleBindingModel.getTitle(),
                articleBindingModel.getEntry(),
                articleBindingModel.getContent(),
                userEntity,
                category,
                tags
        );
        this.articleRepository.saveAndFlush(articleEntity);
        return "redirect:/";
    }

    @PostMapping("/article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editProcess(@PathVariable Integer id, ArticleBindingModel articleBindingModel) {
        if (!this.articleRepository.existsById(id)) {
            return "redirect:/";
        }
        Article article = this.articleRepository.findById(id).orElse(null);
        if (!isUserAuthorOrAdmin(article)) {
            return "redirect:/article/" + id;
        }
        Category category = this.categoryRepository.findById(articleBindingModel.getCategoryId()).orElse(null);
        HashSet<Tag> tags = this.findTagsFromString(articleBindingModel.getTagString());
        article.setCategory(category);
        article.setTitle(articleBindingModel.getTitle());
        article.setEntry(articleBindingModel.getEntry());
        article.setContent(articleBindingModel.getContent());
        article.setTags(tags);
        this.articleRepository.saveAndFlush(article);
        return "redirect:/article/" + article.getId();
    }

    @PostMapping("/article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteProcess(@PathVariable Integer id) {
        if (!this.articleRepository.existsById(id)) {
            return "redirect:/";
        }
        Article article = this.articleRepository.findById(id).orElse(null);
        if (!isUserAuthorOrAdmin(article)) {
            return "redirect:/article/" + id;
        }
        this.articleRepository.delete(article);
        return "redirect:/";
    }

    private boolean isUserAuthorOrAdmin(Article article) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User userEntity = this.userRepository.findByEmail(user.getUsername());
        return userEntity.isAdmin() || userEntity.isAuthor(article);
    }
}
