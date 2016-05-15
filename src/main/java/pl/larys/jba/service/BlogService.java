package pl.larys.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pl.larys.jba.entity.Blog;
import pl.larys.jba.entity.Item;
import pl.larys.jba.entity.User;
import pl.larys.jba.exception.RssException;
import pl.larys.jba.repository.BlogRepository;
import pl.larys.jba.repository.ItemRepository;
import pl.larys.jba.repository.UserRepository;

import java.util.List;

/**
 * Created by piotr on 11.05.16.
 */
@SuppressWarnings("ALL")
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RssService rssService;

    @Autowired
    private ItemRepository itemRepository;

    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
                if (savedItem == null) {
                    item.setBlog(blog);
                    itemRepository.save(item);
                }

            }
        } catch (RssException e) {
            e.printStackTrace();
        }
    }

    // 1 hours = 60 seconds * 60 minutes * 1000
    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        for (Blog blog : blogs) {
            saveItems(blog);
        }
    }

    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);
    }

    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }
}
