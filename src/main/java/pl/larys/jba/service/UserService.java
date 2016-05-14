package pl.larys.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.larys.jba.entity.Blog;
import pl.larys.jba.entity.Item;
import pl.larys.jba.entity.Role;
import pl.larys.jba.entity.User;
import pl.larys.jba.repository.BlogRepository;
import pl.larys.jba.repository.ItemRepository;
import pl.larys.jba.repository.RoleRepository;
import pl.larys.jba.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 01.05.16.
 */
@Service
@Transactional
public class UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RoleRepository roleRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BlogRepository blogRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemRepository itemRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User findOneWithBlogs(int id) {
        User user = findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for (Blog blog : blogs) {
            List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate"));
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));

        user.setRoles(roles);

        userRepository.save(user);
    }

    public User findOneWithBlogs(String name) {
        User user = userRepository.findByName(name);
        return findOneWithBlogs(user.getId());
    }

    public void delete(int id) {
        userRepository.delete(id);
    }
}
