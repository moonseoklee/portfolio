package com.example.portfolio.controller;

import com.example.portfolio.service.Boj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class Main {
    private Boj bojService = new Boj();

    @GetMapping("/")
    public String boj(Model model) throws IOException {

        String[] info = bojService.crawling();
        System.out.println(info[4]);
        model.addAttribute("info",info);

        return "/index";
    }
}
