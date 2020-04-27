package lesson7;

public class AnimalParty {




    public static void main(String[] args) {

        Cat [] catsArray = {new Cat("Барсик>", 5),
                new Cat("Мурзик", 13),
                new Cat("Тузик", 5),
                new Cat("Шарик", 8),
                new Cat("Ромбик", 15),
                new Cat("Толстый", 13),
                new Cat("Худющий", 85)};


        Plate plate = new Plate(85);
        plate.info();
        plate.addFood(64);
        giveEatCats(catsArray,  plate);



    }

    private static void giveEatCats(Cat[] catsArray, Plate plate) {
        for (Cat cat: catsArray) {
            cat.eat(plate);
        }
    }


}
