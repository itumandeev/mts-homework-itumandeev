package ru.mts.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.mts.homework.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.repository.AnimalsRepositoryImp;
import ru.mts.homework.service.CreateAnimalServiceImpl;
import ru.mts.homework.service.SearchServiceimpl;


import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = "ru.mts.*")
public class HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            singletonVsPrototype(ctx);
        };
    }

    private static void singletonVsPrototype(ApplicationContext ctx) throws IOException, InvalidAnimalBirthDateException {
        System.out.println("----- Работа FirstWorkService -----");
        CreateAnimalServiceImpl service = ctx.getBean(CreateAnimalServiceImpl.class);
        SearchServiceimpl searchServiceimpl = ctx.getBean(SearchServiceimpl.class);
        System.out.println(" ");
        searchServiceimpl.checkLeapYearAnimal(service.createAnimal("Cat"));
        System.out.println(" ");
        service.createAnimals("Cat");
        System.out.println(" ");
        AnimalsRepositoryImp animalsRepositoryImp = ctx.getBean(AnimalsRepositoryImp.class);
        System.out.println("findLeapYearNames");
        System.out.println(animalsRepositoryImp.findLeapYearNames());
        System.out.println("findDuplicate");
        System.out.println(animalsRepositoryImp.findDuplicate());
        System.out.println("findOlderAnimal");
        System.out.println(animalsRepositoryImp.findOlderAnimal(100));
        System.out.println("findAverageAge");
        System.out.println(animalsRepositoryImp.findAverageAge());
        System.out.println("findAveragePrice");
        System.out.println(animalsRepositoryImp.findAveragePrice());
        System.out.println("findOldAndExpensive");
        System.out.println(animalsRepositoryImp.findOldAndExpensive(11));
        System.out.println("findMinConstAnimals");
        System.out.println(animalsRepositoryImp.findMinConstAnimals());
    }
}