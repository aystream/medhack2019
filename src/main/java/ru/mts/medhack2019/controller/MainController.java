package ru.mts.medhack2019.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    @Value("${spring.profiles.active:prod}")
    private String profile;

    @GetMapping
    public String main(
            Model model
    ) throws JsonProcessingException {
        HashMap<Object, Object> data = new HashMap<>();
        model.addAttribute("messages", "[]");
        model.addAttribute("profile", "null");

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
