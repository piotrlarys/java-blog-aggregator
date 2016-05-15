package pl.larys.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.larys.jba.service.UserService;

/**
 * Created by piotr on 14.05.16.
 */
@Controller
@RequestMapping("/users")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";
    }

    @RequestMapping(value = "/remove/{id}")
    String removeUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users.html";
    }
}
