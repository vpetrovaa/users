package com.solvd.users.service;

import com.solvd.users.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Mono<User> findById(Long id);

    Mono<User> create(User user);

    Flux<User> createAll(List<User> users);

    Flux<User> findAll();

}
