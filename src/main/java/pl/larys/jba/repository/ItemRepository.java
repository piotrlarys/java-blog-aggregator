package pl.larys.jba.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.jba.entity.Blog;
import pl.larys.jba.entity.Item;

import java.util.List;

/**
 * Created by piotr on 01.05.16.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByBlog(Blog blog, Pageable pageable);
    
}
