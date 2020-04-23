package lesson6;

import jdk.swing.interop.SwingInterOpUtils;
import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

public class Challenge {

    public static void main(String[] args) {

        Animal cat = new Cat("Барсик");
        cat.run(100);
        cat.run(200);

        Animal cat1 = new Cat("Барсик");
        cat1.run(100);
        cat1.run(200);

        Dog dog = new Dog("Балу");
        dog.run(100);
        dog.swimm(12);

        System.out.printf("Количество созданных животных = %d", cat.getAnimalCount());


    }
}
