package com.solvd.users.service.parser;

import com.solvd.users.domain.User;

import java.util.List;

public interface JaxbParser {

    List<User> parse(String filename);
}
