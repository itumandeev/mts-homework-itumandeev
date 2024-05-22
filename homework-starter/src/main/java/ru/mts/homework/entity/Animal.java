package ru.mts.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "animals", name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "character")
    private String character;

    @Column(name = "secretinfo")
    private String secretInfo;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private AnimalType animalType;

    public Animal(String name, String breed, Double cost, String character, String secretInfo) {
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
        this.secretInfo = secretInfo;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String toFileString() {
        return breed + " " + name + " " + cost + " " + character;
    }

}
