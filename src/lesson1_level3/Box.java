package lesson1_level3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list;
    private float weight = 0f;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void addFruit(T fruit){
        list.add(fruit);
        weight += fruit.WEIGHT;
    }

    public float getWeight(){
        return weight;
    }


    public boolean compare(Box o) {
        float a = this.getWeight();
        float b = o.getWeight();
        return Math.abs(this.getWeight() - o.getWeight()) < 0.000001;
    }
}
