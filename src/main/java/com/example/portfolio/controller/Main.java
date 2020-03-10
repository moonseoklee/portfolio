package com.example.portfolio.controller;

import com.example.portfolio.service.Boj;
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


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    @RequestMapping("/download")
    public ResponseEntity<Resource> downloadImg(){
        System.out.println("a");
        String filePath = "C:\\Users\\winny\\OneDrive\\바탕 화면\\MS\\resume\\이문석_이력서";
        File target = new File(filePath);

        HttpHeaders header = new HttpHeaders();
        Resource rs = null;
        if(target.exists()) {
            try {
                String mimeType = Files.probeContentType(Paths.get(target.getAbsolutePath()));
                if(mimeType == null) {
                    mimeType = "octet-stream";
                }
                rs = new UrlResource(target.toURI());
                header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ rs.getFilename() +"\"");
                header.setCacheControl("no-cache");
                header.setContentType(MediaType.parseMediaType(mimeType));
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<Resource>(rs, header, HttpStatus.OK);
    }

}
