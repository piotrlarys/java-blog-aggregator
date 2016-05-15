package pl.larys.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.larys.jba.service.ItemService;

/**
 * Created by piotr on 29.04.16.
 */
@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("items", itemService.geItems());
        return "index";
    }
}
