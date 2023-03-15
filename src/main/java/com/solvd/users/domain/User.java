package com.solvd.users.domain;

import com.solvd.users.service.parser.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "users")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @Id
    private Long id;

    private String email;

    private String password;

    private String name;

    private String surname;

    private String phone;

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate birthday;

}
