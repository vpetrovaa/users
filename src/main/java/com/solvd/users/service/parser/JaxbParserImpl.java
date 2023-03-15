package com.solvd.users.service.parser;

import com.solvd.users.domain.User;
import com.solvd.users.domain.exception.ResourceDoesNotExistException;
import com.solvd.users.domain.parser.Users;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;

import java.net.URL;
import java.util.List;

@Component
public class JaxbParserImpl implements JaxbParser{

    @Override
    @SneakyThrows
    public List<User> parse(String filename) {
        URL resource = getClass().getClassLoader().getResource(filename);
        if(resource == null) {
            throw new ResourceDoesNotExistException("Please check does file in resource folder exist");
        }
        File file = new File(resource.toURI());
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Users usersParsed = (Users) jaxbUnmarshaller.unmarshal(file);
        return usersParsed.getUsers();
    }

}
