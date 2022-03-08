package com.example.springwebflux.service;

import com.example.springwebflux.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.time.Duration;

@Service
public class UserService {

    public Flux<User> getData() {
        return Flux.range(1,50).delayElements(Duration.ofSeconds(1))
                .map(i -> new User(i));
    }
}
