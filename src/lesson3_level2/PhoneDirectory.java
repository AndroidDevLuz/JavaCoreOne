package lesson3_level2;

import java.util.*;

public class PhoneDirectory  {

    Map<String, Set<String>> list = new HashMap<>();

    public void add(String lastName, String number){


        if(list.containsKey(lastName)) {
            Set<String> number1 = list.get(lastName);
            number1.add(number);
            list.put(lastName, number1);
        } else{
            Set<String> number2 = new HashSet<>();
            number2.add(number);
            list.put(lastName, number2);
        }
    }

    public Set<String> get(String lastName){
        return list.get(lastName);
    }

}
