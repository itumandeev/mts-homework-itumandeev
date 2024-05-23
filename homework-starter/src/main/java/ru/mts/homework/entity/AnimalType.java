package ru.mts.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "animals", name = "animal_type")
public class AnimalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "type")
    private String type;

    @Column(name = "extra_info")
    private String extraInfo;

    @OneToMany(mappedBy = "animalType", cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE}, orphanRemoval = true)
    private List<Animal> animalList;

    public AnimalType(String type, String extraInfo) {
        this.type = type;
        this.extraInfo = extraInfo;
    }
}
