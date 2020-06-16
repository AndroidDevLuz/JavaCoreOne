package lesson1_level3.task_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        List<String> stringArray = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        System.out.println(stringArray);
        System.out.println(replaceTwoIndexes(stringArray,3,4));
        System.out.println();
        List<Integer> integerArray = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(integerArray);
        System.out.println(replaceTwoIndexes(integerArray,3,4));

    }


    public static  <T> List<T> replaceTwoIndexes(List<T> list, int a,int b){
        T indexA = list.get(a);
        T indexB = list.get(b);
        list.set(a,indexB);
        list.set(b,indexA);
        return list;
    }

}
