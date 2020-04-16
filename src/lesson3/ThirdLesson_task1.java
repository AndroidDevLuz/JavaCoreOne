package lesson3;

import java.util.Scanner;

public class ThirdLesson_task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userAnswer;
        int computerNumber;
        do {
            System.out.println("Введите число, которое загадал компьютер!)");
            computerNumber = (int) (Math.random() * 9);
            userAnswer = scanner.nextInt();

        do {

            if(userAnswer < computerNumber){
                System.out.println("Ваше число меньше чем загадал компьютер");
            } else {
                System.out.println("Ваше число больше чем загадал компьютер");
            }

            System.out.println("Введите число, которое загадал компьютер");
            userAnswer = scanner.nextInt();

        } while(userAnswer == computerNumber);

            System.out.println("Поздравляю, Вы угадали число!)");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            userAnswer = scanner.nextInt();

        } while(userAnswer == 1);

        scanner.close();

    }

}
