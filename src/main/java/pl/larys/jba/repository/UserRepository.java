package pl.larys.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.jba.entity.User;

/**
 * Created by piotr on 01.05.16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
}
