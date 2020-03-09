package com.example.portfolio.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Boj {

    public String[] crawling() throws IOException {

        String url = "https://www.acmicpc.net/user/winnyiee";
        String url2 = "https://solved.ac/winnyiee/overview";
        Document doc = Jsoup.connect(url).get();
        Document doc2 = Jsoup.connect(url2).get();
        Elements elem = doc.select("table");
        Elements elem2 = doc2.getElementsByClass("userinfo_tier_container").select("div>span>b");

       ;
        String temp[] = elem.text().split(" ");
        temp[0] = elem2.text();
        for(int i=0;i<20;i++){
            System.out.println(temp[i]);
        }

        return temp;
        //String[] str = elem.text().split(" ");
        //Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");



    }
}



