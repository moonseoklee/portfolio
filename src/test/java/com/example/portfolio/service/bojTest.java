package com.example.portfolio.service;






import org.junit.Test;


import java.io.IOException;



public class bojTest {


    private Boj t;

    @Test
    public void crawling() throws IOException {
        t = new Boj();
        System.out.println(t.crawling());


    }
}