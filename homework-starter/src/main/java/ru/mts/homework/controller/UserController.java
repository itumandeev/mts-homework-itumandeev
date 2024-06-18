package ru.mts.homework.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mts.homework.entity.User;
import ru.mts.homework.exeption.CustomException;
import ru.mts.homework.exeption.UserNotFoundException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class UserController {

    //задание 1
    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World!";
    }

    //задание 2
    @PostMapping(value = "/greet")
    public String postGreet(@RequestBody Map<String, String> body) {
        return body.get("name");
    }

    //задание 3
    @PostMapping(value = "/greet2")
    public String postGreet2(@Valid User user) {
        return "Регистрация прошла успешно";
    }

    //задание 4/ 10
    @PostMapping(value = "/user/{id}")
    public String postUserGetData(@PathVariable String id, @RequestParam(defaultValue ="Guest", required=false) String name) {
        return "ID: " + id + " name: " +name;
    }

    //задание 5
    @GetMapping(value = "/usernotfound")
    public String getUserNotFound() {
        throw  new UserNotFoundException();
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex) {
        System.out.println("UserNotFoundException: " + ex.getMessage());
        return new ResponseEntity<Object>("Error message example", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    //задание 6
    @GetMapping(value = "/UserAgent")
    public String getUserAgent(@RequestHeader(HttpHeaders.USER_AGENT) String param) {
        return param;
    }

    //задание 8
    @GetMapping("/customex")
    public String customex(@RequestHeader HttpHeaders headers) {
        throw new CustomException();
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "CustomExceptionon !")
    @ExceptionHandler(value = CustomException.class)
    public void handleCustomException(CustomException ex) {
    }

    //задание 9
    @GetMapping("/date/{date}")
    public String dateCheck(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return "date= " + date;
    }
}