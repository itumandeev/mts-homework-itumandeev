package ru.mts.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mts.homework.entity.AnimalType;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
    public AnimalType findByType(String type);
}