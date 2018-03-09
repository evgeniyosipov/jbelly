package ru.evgeniyosipov.jbelly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgeniyosipov.jbelly.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
