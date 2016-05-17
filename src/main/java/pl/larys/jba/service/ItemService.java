package pl.larys.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.larys.jba.entity.Item;
import pl.larys.jba.repository.ItemRepository;

import java.util.List;

/**
 * Created by piotr on 15.05.16.
 */
@Service
public class ItemService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> geItems() {
        return itemRepository.findAll(new PageRequest(0, 20, Sort.Direction.ASC, "publishedDate")).getContent();
    }
}
