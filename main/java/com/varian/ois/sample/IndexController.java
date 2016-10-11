package com.varian.ois.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gbt1220 on 9/29/2016.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "dadepo");
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
