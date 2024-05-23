package ru.mts.homework.service;

import org.springframework.stereotype.Service;
import ru.mts.homework.entity.Animal;
import ru.mts.homework.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public void save(Animal animal) {
        animalRepository.save(animal);
    }
}
