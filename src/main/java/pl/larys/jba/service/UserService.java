package pl.larys.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.larys.jba.entity.User;
import pl.larys.jba.repository.UserRepository;

import java.util.List;

/**
 * Created by piotr on 01.05.16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
