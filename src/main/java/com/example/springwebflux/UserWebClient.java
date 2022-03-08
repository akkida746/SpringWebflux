package com.example.springwebflux;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class UserWebClient {

    WebClient webClient = WebClient.create("http://localhost:8080");

    public void consume(){
        Flux<String> userFlux = webClient.get().uri("/greeting").retrieve().bodyToFlux(String.class);
        userFlux.subscribe(msg -> System.out.println(msg));
    }
}
