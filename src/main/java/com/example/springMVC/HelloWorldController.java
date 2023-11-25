package com.example.springMVC;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @GetMapping("/processForm2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String theName = request.getParameter("userName");
        theName = theName.toUpperCase();
        String result = "YO! "+theName;
        model.addAttribute("message", result);
        return "helloworld";
    }

    @GetMapping("/processForm3")
    public String letsShoutDude2(
            @RequestParam ("userName")
            String theName, Model model) {

        theName = theName.toUpperCase();
        String result = "Hey mate!: " + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
