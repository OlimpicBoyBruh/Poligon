package ru.edu;

import org.springframework.web.client.RestTemplate;

public class Test {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String s1 = restTemplate.getForObject("https://httpbin.org/get", String.class);

        System.out.println(s1);
    }
}
