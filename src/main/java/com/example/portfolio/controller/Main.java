package com.example.portfolio.controller;

import com.example.portfolio.service.Boj;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.net.www.http.HttpClient;


import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class Main {
    private Boj bojService = new Boj();

    @GetMapping("/src/main/resources/templates/index")
    public String boj(Model model) throws IOException {

        String[] info = bojService.crawling();
        System.out.println(info[4]);
        model.addAttribute("info",info);

        return "/index";
    }


}
