package ro.ase.translatorApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    public String getHello(){
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
