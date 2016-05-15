package pl.larys.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.larys.jba.entity.User;
import pl.larys.jba.service.UserService;

import javax.validation.Valid;

/**
 * Created by piotr on 14.05.16.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }

    @RequestMapping
    public String showRegister() {
        return "user-register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userService.save(user);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/available")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean available = userService.findOne(username) == null;
        return available.toString();

    }
}
