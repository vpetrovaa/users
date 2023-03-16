package com.solvd.users.web.controller;

import com.solvd.users.domain.User;
import com.solvd.users.service.UserService;
import com.solvd.users.service.parser.JaxbParser;
import com.solvd.users.web.dto.UserDto;
import com.solvd.users.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JaxbParser jaxbParser;

    @GetMapping("/{id}")
    public Mono<UserDto> findById(@PathVariable Long id) {
        Mono<User> user = userService.findById(id);
        return user.map(userMapper::entityToDto);
    }

    @PostMapping
    public Mono<UserDto> create(@RequestBody @Validated UserDto userDto) {
        User userMapped = userMapper.dtoToEntity(userDto);
        Mono<User> user = userService.create(userMapped);
        return user.map(userMapper::entityToDto);
    }

    @GetMapping
    public Flux<UserDto> findAll() {
        Flux<User> users = userService.findAll();
        return users.map(userMapper::entityToDto);
    }

    @PostMapping("/parser")
    public Flux<UserDto> createAll(@RequestParam MultipartFile file) {
        List<User> usersParsed = jaxbParser.parse(file);
        Flux<User> users = userService.createAll(usersParsed);
        return users.map(userMapper::entityToDto);
    }

}
