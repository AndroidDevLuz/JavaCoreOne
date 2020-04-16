package lesson3;

import java.util.Scanner;

public class ThirdLesson_task2 {




    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon",
                "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};


        int number = (int) (Math.random() * words.length);
        String computerString = words[number];
        //System.out.println("Компьютер загадал слово "+computerString);
        String userInput;
        int i = 0;
        do {
            showHint(i,computerString);
            System.out.println("Введите слово, которое загадал компьютер");
            userInput = scanner.nextLine();
            i++;
        } while(!userInput.equals(computerString));
        System.out.println("Поздравляю, ты угадал слово");

        scanner.close();

    }

    private static void showHint(int i, String computerString) {

        if(i >0) {
        String hint = computerString.substring(0,i);
        StringBuilder sb = new StringBuilder();
        sb.append(hint);
        for(int j=i;j< computerString.length();j++){
            sb.append("#");
        }
        System.out.println("Я открою тебе несколько букв "+sb.toString());

        }
    }


}
