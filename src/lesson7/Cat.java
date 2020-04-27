package lesson7;

public class Cat {

    private String name;
    private int appetite;
    private static boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }

    public void eat(Plate p) {
        full = p.decreaseFood(appetite);
        if (full) {
            System.out.println("Кот " + name + " очень сыт");
        } else {
            System.out.println("Мне мало еды");
        }
    }
}
