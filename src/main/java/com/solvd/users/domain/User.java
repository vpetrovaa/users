package com.solvd.users.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String email;

    private String password;

    private String name;

    private String surname;

    private String phone;

    private LocalDate birthday;

}
