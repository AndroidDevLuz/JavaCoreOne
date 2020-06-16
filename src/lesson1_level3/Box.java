package lesson1_level3;

import java.util.ArrayList;
import java.util.List;

public class Box<T> implements Comparable<Box> {

    private List<T> list;
    private float weight = 0f;

    public Box() {
        this.list = new ArrayList<>();
    }

    public float getWeight(){
        return 0;
    }




    @Override
    public int compareTo(Box o) {
        return (int)(this.weight = o.weight);
    }
}
