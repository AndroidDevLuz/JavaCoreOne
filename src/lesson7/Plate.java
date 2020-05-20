package lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food - n >= 0) {
            food -= n;
            infoResidue();
            return true;
        }
        System.out.println("Кот хочет сьесть: " + n + ", а в тарелке осталось "+ food+". Добавьте "+(n-food)+" вкусной еды");
        return false;

    }


    public void addFood(int n) {
        food += n;
        info();
    }

    private void infoResidue() {
        System.out.println("В тарелке осталось: " + food);
    }


    public void info() {
        System.out.println("plate: " + food);
    }
}
