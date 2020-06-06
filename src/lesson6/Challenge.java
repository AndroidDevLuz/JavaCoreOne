package lesson6;

import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

public class Challenge {

    public static void main(String[] args) {

        Animal cat = new Cat("Барсик");
        cat.run(100);

        Animal cat1 = new Cat("Муся");
        cat1.run(100);

        Animal cat2 = new Cat("Кися");
        cat2.run(100);

        Dog dog = new Dog("Балу");
        dog.run(100);
        dog.swimm(12);

        Dog dog1 = new Dog("Кавказский коронавирус");
        dog1.run(100);
        dog1.swimm(12);

        Dog dog2 = new Dog("Рэкс");
        dog2.run(100);
        dog2.swimm(12);

        System.out.printf("Количество созданных животных = %d", cat.getAnimalCount());


    }
}
