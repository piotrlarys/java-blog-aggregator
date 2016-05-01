package pl.larys.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.jba.entity.Item;

/**
 * Created by piotr on 01.05.16.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
