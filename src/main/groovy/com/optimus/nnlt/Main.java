package com.optimus.nnlt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Main {
    @GetMapping("/")
    String viewHomePage() {
        return "/welcome";
    }
}
