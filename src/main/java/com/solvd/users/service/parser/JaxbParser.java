package com.solvd.users.service.parser;

import com.solvd.users.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JaxbParser {

    List<User> parse(MultipartFile file);

}
