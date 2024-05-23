package ru.mts.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mts.homework.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}