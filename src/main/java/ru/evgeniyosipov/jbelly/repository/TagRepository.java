package ru.evgeniyosipov.jbelly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgeniyosipov.jbelly.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByName(String name);
}
