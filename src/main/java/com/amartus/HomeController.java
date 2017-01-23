package com.amartus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khe on 2017-01-23.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "This is a start page for ART!");
        model.addAttribute("tagline", "Amartus Reporting Tool");

        return "welcome";
    }
}
