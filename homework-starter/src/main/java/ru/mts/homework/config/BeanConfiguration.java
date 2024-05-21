package ru.mts.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.mts.homework.service.CreateAnimalServiceImpl;
import ru.mts.homework.util.SaveInfoToFile;

import java.util.List;

@Configuration
@PropertySource("classpath:app.properties")
public class BeanConfiguration {

    @Value("#{'${animal.names}'.split(',')}")
    List<String> names;
    @Value("#{'${animal.characters}'.split(',')}")
    List<String> characters;
    @Value("#{'${animal.breeds}'.split(',')}")
    List<String> breeds;

    @Bean
    @Scope("prototype")
    public CreateAnimalServiceImpl createAnimalServiceImpl() {
        SaveInfoToFile saveInfoToFile = new SaveInfoToFile();
        return new CreateAnimalServiceImpl(names, characters, breeds, saveInfoToFile);
    }

//    @Bean
//    public SaveInfoToFile saveInfoToFile() {
//        return new SaveInfoToFile();
//    }
}