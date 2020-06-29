package lesson1_level3.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {




    public static void main(String[] args) {

        List<String> stringArray = Arrays.asList("A","B","C","D","E");
        List<Integer> integerArray = new LinkedList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(returnOnlyArrayList(stringArray).get(3));
        System.out.println(returnOnlyArrayList(integerArray).get(0));

    }


    public static  <T> ArrayList<T> returnOnlyArrayList(List<T> list){
        return new ArrayList<>(list);
    }
}
