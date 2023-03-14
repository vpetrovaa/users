package com.solvd.users.service.impl;

import com.solvd.users.domain.User;
import com.solvd.users.domain.exception.ResourceAlreadyExistsException;
import com.solvd.users.domain.exception.ResourceDoesNotExistException;
import com.solvd.users.repository.UserRepository;
import com.solvd.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Mono<User> findById(Long id) {
        return Mono.just(id)
                .flatMap(userRepository::findById)
                .switchIfEmpty(Mono.error(new ResourceDoesNotExistException("There are no user with id " + id)));
    }

    @Override
    public Mono<User> create(User user) {
        return userRepository.existsByEmail(user.getEmail())
                .flatMap(isExist -> {
                    if (isExist) {
                        return Mono.error(new ResourceAlreadyExistsException("User with email " + user.getEmail() + " already exists"));
                    }
                    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                    return userRepository.save(user);
                });
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

}
