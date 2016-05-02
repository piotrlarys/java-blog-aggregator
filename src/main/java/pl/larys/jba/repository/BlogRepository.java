package pl.larys.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.jba.entity.Blog;
import pl.larys.jba.entity.User;

import java.util.List;

/**
 * Created by piotr on 01.05.16.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findByUser(User user);
    
}
