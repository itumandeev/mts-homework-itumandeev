package ru.mts.homework.service;

import org.springframework.stereotype.Service;
import ru.mts.homework.entity.AnimalType;
import ru.mts.homework.repository.AnimalTypeRepository;

import java.util.Optional;


@Service
public class AnimalTypeService {
    private final AnimalTypeRepository animalTypeRepository;

    public AnimalTypeService(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    public AnimalType save(AnimalType animalType) {
        return animalTypeRepository.save(animalType);
    }

    public AnimalType findById(Long id) {
        return animalTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Not found animal type with id %s", id)));
    }

    public AnimalType findByType(String type) {
        AnimalType animalType = animalTypeRepository.findByType(type);
        return animalType;
    }
}
