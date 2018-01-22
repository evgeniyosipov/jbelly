package ru.evgeniyosipov.jbelly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgeniyosipov.jbelly.entity.Category;

public interface CategoryRepository
        extends JpaRepository<Category, Integer>{

}
