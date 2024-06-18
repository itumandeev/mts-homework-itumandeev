package ru.mts.homework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class User {

    @NotNull(message = "Name is null!")
    @NotBlank(message = "Name is null!")
    @Size(min=3, message="Name must be at least 3 characters long")
    String name;

    @Email(message = "Email not valid")
    @NotBlank(message = "email is null!")
    String email;
}