package ru.mts.homework.lesson3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "breed")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "Dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "Cat"),
        @JsonSubTypes.Type(value = Shark.class, name = "Shark"),
        @JsonSubTypes.Type(value = Wolf.class, name = "Wolf"),
}
)
/**
 * @author ITUMANDEEV
 * version 0.2
 */
public abstract class AbstractAnimal implements Animal, Externalizable {
    /**
     * поле порода
     */
    protected String breed;
    /**
     * поле имя
     */
    protected String name;
    /**
     * поле цена
     */
    protected double cost;
    /**
     * поле характер
     */
    protected String character;
    /**
     * поле дата рождения
     */
    protected LocalDate birthDate;
    /**
     * скрытая информация
     */
    protected String secretInfo;

    public AbstractAnimal(String breed, String name, Double cost, String character, String secretInfo, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.secretInfo = secretInfo;
        this.birthDate = birthDate;
        setSecretInfo();
    }

    public AbstractAnimal(String breed, String name, Double cost) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        setSecretInfo();
    }

    public AbstractAnimal(String breed, String name) {
        this.breed = breed;
        this.name = name;
        setSecretInfo();
    }

    public AbstractAnimal() {
        setSecretInfo();
        this.birthDate = LocalDate.now();
        this.cost = 1000D;
    }

    public String getSecretInfomation() {
        return this.secretInfo;
    }

    public void setSecretInfo() {
        Path secPath = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "secretStore", "secretInformation.txt");
        Random r = new Random();
        String line = "";
        List<String> list = new ArrayList<>();
        if (Files.exists(secPath)) {
            try {
                list = Files.readAllLines(secPath);
                line = list.get(r.nextInt(list.size()));

            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        this.secretInfo = line;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(breed);
        out.writeUTF(name);
        out.writeDouble(cost);
        out.writeUTF(String.valueOf(birthDate));
        out.writeUTF(encryptString(secretInfo));
    }

    private static String encryptString(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decryptString(String data) {
        return new String(Base64.getDecoder().decode(data));
    }

    public String toFileString() {
        return breed + " " + name + " " + cost + " " + birthDate;
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.breed = in.readUTF();
        this.name = in.readUTF();
        this.cost = in.readDouble();
        this.birthDate = LocalDate.parse(in.readUTF());
        this.secretInfo = decryptString(in.readUTF());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost)
                && Objects.equals(character, that.character) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}