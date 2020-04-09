


public class FirstLesson {

    //переменные всех пройденных типов данных и инициализировать их значения
    private static byte varByte = -120;
    private static short varShort = 12442;
    private static int varInt = 1000;
    private static long varLong = 200000L;
    private static float varFloat = 12.23f;
    private static double varDouble = -123.123;
    private static char varChar = 'L';
    private static boolean varBoolean = true;
    private static String firstLesson = "Фанзиль!";


    public static void main(String[] args) {
        System.out.println(calculate(varInt, varInt, varInt, varInt));
        System.out.println(task10and20(5, 6));
        isPositiveOrNegative(-30);
        System.out.println(isNegative(varByte));
        greetings(firstLesson);
        isBissextileYear(2016);
        isBissextileYear(2017);
        isBissextileYear(2018);
        isBissextileYear(2019);
        isBissextileYear(2020);
    }

    //метод вычисляющий выражение a * (b + (c / d))
    public static int calculate(int a, int b, int c, int d) {
        //Без проверки деления на 0
        return a * (b + (c / d));
    }

    //метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
    public static boolean task10and20(int x1, int x2) {
        int sum = x1 + x2;
        return 10 <= sum && sum <= 20;
    }

    //метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    public static void isPositiveOrNegative(int x) {
        String positiveNumber = "Вы ввели положительное число";
        String negativeNumber = "Вы ввели отрицательное число";
        System.out.println(x >= 0 ? positiveNumber : negativeNumber);
    }

    //метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное
    public static boolean isNegative(int x) {
        return x >= 0;
    }

    //метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static void greetings(String name) {
        System.out.println("Привет,"+ name);
    }

    /**Написать метод, который определяет, является ли год високосным,
     и выводит сообщение в консоль. Каждый 4-й год является
     високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/
    public static void isBissextileYear(int x) {
        if (x % 4 == 0) {
            if ((x % 100 != 0) || (x % 400 == 0)) {
                System.out.println(x+" год является високосным");
            }
        }
    }
}
