package com.gab.sprintsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/"})
    public String home() {
        return "index";
    }

    @GetMapping("/carte")
    public String carte() {
        return "carte";
    }

}
