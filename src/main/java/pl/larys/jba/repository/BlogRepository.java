package pl.larys.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.jba.entity.Blog;

/**
 * Created by piotr on 01.05.16.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    
}
