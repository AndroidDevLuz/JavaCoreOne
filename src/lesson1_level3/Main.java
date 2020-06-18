package lesson1_level3;

public class Main {



    public static void main(String[] args) {

        Box<Apple> fruitApple = new Box<>();
        Box<Apple> fruitApple1 = new Box<>();
        Box<Orange> fruitOrange = new Box<>();

        fillApples(fruitApple);
        fillApples(fruitApple1);
        fillOranges(fruitOrange);

        System.out.println(fruitApple.getWeight());
        System.out.println(fruitApple1.getWeight());
        System.out.println(fruitOrange.getWeight());

        System.out.println(fruitApple.compare(fruitOrange));


        System.out.println(fruitApple.compare(fruitApple1));



    }

    private static void fillApples(Box<Apple> fruitApple) {
        for(int i=0; i<30;i++){
            fruitApple.addFruit(new Apple());
        }
    }

    private static void fillOranges(Box<Orange> fruitApple) {
        for(int i=0; i<20;i++){
            fruitApple.addFruit(new Orange());
        }
    }
}
