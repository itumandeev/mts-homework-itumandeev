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

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "ru.mts.*")
public class HomeworkApplication {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalTypeService animalTypeService;


    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            AnimalType animalType1 = new AnimalType("Травоядные", "Боятся хищников");
            System.out.println("Выполнено создание типа1");
            animalTypeService.save(animalType1);
            AnimalType animalType2 = new AnimalType("Домашние животные", "ласковые");
            System.out.println("Выполнено создание типа2");
            animalTypeService.save(animalType2);
            System.out.println("Выполнено сохранение типа");

            Animal animal1 = new Animal("Барсик","сиамский",12312.1,"спокойный","ссыт в тапки");
            animal1.setAnimalType(animalTypeService.findByType("Домашние животные"));
            System.out.println("Выполнено создание животного");
            animalService.save(animal1);
            System.out.println("Выполнено сохранение животного");
        };
    }
}