package com.solvd.users.service.parser;

import com.solvd.users.domain.User;
import com.solvd.users.domain.parser.Users;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;

import java.util.List;

@Component
public class JaxbParserImpl implements JaxbParser{

    @Override
    @SneakyThrows
    public List<User> parse(MultipartFile file) {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Users usersParsed = (Users) jaxbUnmarshaller.unmarshal(new BufferedInputStream(file.getInputStream()));
        return usersParsed.getUsers();
    }

}
