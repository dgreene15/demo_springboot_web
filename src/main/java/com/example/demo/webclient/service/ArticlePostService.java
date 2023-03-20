package com.example.demo.webclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ArticlePostService {

    @Autowired
    private WebClient webClientTypicode;

    public Mono<String> getArticlePost(Integer id) {
        log.info("EmployeeService: (id:{})", id);

        return webClientTypicode.get()
                .uri("posts/" + id)
                .retrieve()
                .bodyToMono(String.class);
    }

}