package ru.evgeniyosipov.jbelly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgeniyosipov.jbelly.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
