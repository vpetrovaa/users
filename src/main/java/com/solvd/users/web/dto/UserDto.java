package com.solvd.users.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;

    @Email(message = "Enter your email")
    @NotBlank(message = "Email cant be empty")
    private String email;

    @Size(min = 10, max = 30, message = "Password must be from 10 to 30 symbols")
    @NotBlank(message = "Password cant be empty")
    private String password;

    @Size(min = 3, max = 45, message = "Name must be from 3 to 45 symbols")
    @NotBlank(message = "Name cant be empty")
    private String name;

    @Size(min = 3, max = 45, message = "Surname must be from 3 to 45 symbols")
    @NotBlank(message = "Surname cant be empty")
    private String surname;

    @Size(min = 12, max = 12, message = "Phone must be 12 symbols")
    @NotBlank(message = "Phone cant be empty")
    private String phone;

    private LocalDate birthday;

}
