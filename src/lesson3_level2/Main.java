package lesson3_level2;

import java.util.*;

public class Main {

    public static Map<String, Integer> letters = new HashMap<>();
    public static List<String> simpleArray = new ArrayList<>();

    public static void main(String[] args) {


        //1.Задание

        simpleArray.add("Dog");
        simpleArray.add("Cat");
        simpleArray.add("Cat");
        simpleArray.add("RadMadRobots");
        simpleArray.add("Human");
        simpleArray.add("CocaCola");
        simpleArray.add("Pepsi");
        simpleArray.add("Fanya");
        simpleArray.add("Dog");
        simpleArray.add("Dog");
        simpleArray.add("RadMadRobots");
        simpleArray.add("RadMadRobots");

        enumerateElements(simpleArray);
        printUniqueElements(simpleArray);
        printElementsCount(letters);

        //2 Задание
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Лузянин", "89166420458");
        phoneDirectory.add("Лузянин", "89168888888");
        phoneDirectory.add("Лузянин", "89167777777");

        System.out.println(String.format("Телефоны %s %s","Лузянина(ой)",phoneDirectory.get("Лузянин")));
    }

    private static void enumerateElements(List<String> simpleArray) {
        simpleArray.forEach(element->{
            letters.put(element, !letters.containsKey(element) ? 1 : letters.get(element) + 1);
        });
    }

    private static void printElementsCount(Map<String, Integer> letters) {
        letters.forEach( (k,v)->{
            System.out.println("Элемент "+k+" Количество в массиве "+v);
        });
    }

    private static void printUniqueElements(List<String> simpleArray) {
        System.out.println("Уникальные элементы "+new HashSet<>(simpleArray));
    }
}
