package com.example.portfolio.service;






import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;



public class bojTest {


    private Boj t;

    @Test
    public void crawling() throws IOException {
        t = new Boj();
        System.out.println(t.crawling());


    }
}