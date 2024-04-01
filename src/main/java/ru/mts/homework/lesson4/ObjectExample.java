package ru.mts.homework.lesson4;

import java.util.Objects;

public class ObjectExample {

    static class Example {
        private String name;
        private int count;

        public Example(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Example example = (Example) o;
            return count == example.count && Objects.equals(name, example.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, count);
        }

        @Override
        public String toString() {
            return "Example{" +
                    "name='" + name + '\'' +
                    ", count=***" +
                    '}';
        }
    }

    public static void main(String[] args) {

        //System.out.println(first.getClass());

        //System.out.println(first.hashCode());
        //System.out.println(first.equals());

        Example first = new Example("first", 1);
        Example second = new Example("second", 2);
        Example duplicate = new Example("first", 1);
        Example secondDuplicate = new Example("first", 1);

        System.out.println(first.toString());
        System.out.println(second.toString());

        System.out.println(first.equals(second));

        //cимметричность
        System.out.println(first.equals(duplicate));
        System.out.println(duplicate.equals(first));

        //транзитивность
        System.out.println(first.equals(duplicate));
        System.out.println(duplicate.equals(secondDuplicate));
        System.out.println(first.equals(secondDuplicate));

        //правила
        System.out.println(first.equals(null));
        System.out.println(first.equals(first));
    }
}
