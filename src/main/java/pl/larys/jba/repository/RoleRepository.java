package pl.larys.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.jba.entity.Role;

/**
 * Created by piotr on 01.05.16.
 */
public interface RoleRepository  extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
