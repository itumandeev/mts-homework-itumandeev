package ru.mts.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.mts.homework.entity.Animal;
import ru.mts.homework.entity.AnimalType;
import ru.mts.homework.service.AnimalService;
import ru.mts.homework.service.AnimalTypeService;

@SpringBootApplication
@ComponentScan(basePackages = "ru.mts.*")
public class HomeworkApplication {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalTypeService animalTypeService;


    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
        org.apache.log4j.BasicConfigurator.configure();
        System.setProperty("log4j.debug", "");
    }
}