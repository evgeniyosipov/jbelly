package ru.evgeniyosipov.jbelly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgeniyosipov.jbelly.entity.Role;

/**
 * Created by Evgeniy Osipov on 14.05.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
