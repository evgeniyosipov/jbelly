package ru.evgeniyosipov.jbelly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgeniyosipov.jbelly.entity.User;

/**
 * Created by Evgeniy Osipov on 14.05.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}
