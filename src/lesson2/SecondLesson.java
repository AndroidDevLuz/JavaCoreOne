package lesson2;

import java.util.Arrays;

public class SecondLesson {


    private static int[][] array_4;
    private static int position;


    public static void main(String[] args) {

        //1.Задание
        int[] array_1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        //Распечатать исходный массив
        System.out.print("Массив исходный:        ");
        printCurrentArray(array_1);
        //Перейти на другую строку
        System.out.println();
        //С помощью цикла и условия заменить 0 на 1, 1 на 0 в исходном массиве и напечать в консоль
        replaceZeroToOne(array_1);

        //2.Задание
        //Перейти на другую строку
        System.out.println();
        int array_2[] = new int[8];
        fillArray(array_2);

        //3.Задание
        //Перейти на другую строку
        System.out.println();
        int[] array_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Массив исходный:          ");
        printCurrentArray(array_3);
        System.out.println();
        numberMulByTwo(array_3);

        //4.Задание
        //Перейти на другую строку
        System.out.println();
        array_4 = new int[10][10];
        fillArrayNumbers();

        //Перейти на другую строку
        System.out.println();
        fillDiagonalArray();

        //5.Задание ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] array_5 = {1, 5, 3, 2, 11, 4, 345, 2, 4, 8, -9, 1};
        findMinAndMaxInArray(array_5);


        //6.Задание ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
        // в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        //{1, 5, 3, 2, 11, 4,  || 5, 2, 4, 8, - 9, 1};
        int[] array_6 = {1, 1, 3, 3, 1, 4, 3};
        if(compareSums(array_6)){
            int number = array_6[position];
            array_6[position] = 999999;
            String stringArray = Arrays.toString(array_6);
            String newStringArray = stringArray.replace("999999", "||"+number);
            //Выведем массив строкой и покажем место,в котором сумма левой и правой части массива равны
            System.out.println(newStringArray);
        } else {
            System.out.println(compareSums(array_6));
        }


        //Перейти на другую строку
        System.out.println();

        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементымассива на n позиций. 
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] array_7 = {1, 1, 1, 1, 8, 1, 1};
        System.out.println(Arrays.toString(array_7));
        shiftArray(array_7, 5);
        System.out.println(Arrays.toString(array_7));

        //Перейти на другую строку
        System.out.println();

        int[] array_8 = {1, 1, 1, 1, 1, 1, 9};
        System.out.println(Arrays.toString(array_8));
        shiftArray(array_8, -5);
        System.out.println(Arrays.toString(array_8));


    }

    private static void shiftArray(int[] array_7, int shift) {

        if(shift > 0) {
            for (int i = 0; i < shift; i++) {
                //кладём 0 элемент в переменную
                int tempVar = array_7[0];

                for (int j = 0; j < array_7.length - 1; j++) {
                    //копиируем элемент из правой ячееки в левую
                    array_7[j] = array_7[j + 1];
                }
                //присваиваем последнему элементу  массива ссылку на значение 0 элемента
                array_7[array_7.length - 1] = tempVar;

            }

        } else {
            for (int i = 0; i < Math.abs(shift); i++) {
                //кладём 0 элемент в переменную
                int tempVar = array_7[array_7.length - 1];

                for (int j = array_7.length - 1; j > 0; j--) {
                    //копиируем элемент из левой ячееки в правую
                    array_7[j] = array_7[j - 1];
                }
                //присваиваем 0 элементу массива ссылку на значение последнего элемента
                array_7[0] = tempVar;

            }
        }
    }

    private static boolean compareSums(int[] array_6) {
        int LeftSum;
        int RightSum;


        for (int count = 0; count < array_6.length; count++) {
            LeftSum = arrayLeftSum(array_6, count);
            RightSum = arrayRightSum(array_6, count + 1);
            System.out.println(LeftSum);
            System.out.println(RightSum);
            System.out.println();
            if (LeftSum == RightSum) {
                position = count;
                return true;
            }
        }

        return false;
    }

    private static int arrayLeftSum(int[] array_6, int count) {
        int sum = 0;
        for (int i = 0; i <= count; i++) {
            sum = sum + array_6[i];
        }
        return sum;
    }

    private static int arrayRightSum(int[] array_6, int count) {
        int sum = 0;
        for (int i = count; i < array_6.length; i++) {
            sum = sum + array_6[i];
        }
        return sum;
    }

    private static void findMinAndMaxInArray(int[] array_5) {
        int min = 0;
        int max = 0;
        for (int i : array_5) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
    }

    private static void fillArrayNumbers() {

        for (int i = 0; i < array_4.length; i++) {
            for (int j = 0; j < array_4.length; j++) {
                array_4[i][j] = 0;
                System.out.print(array_4[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void fillDiagonalArray() {
        for (int i = 0; i < array_4.length; i++) {
            for (int j = 0; j < array_4[i].length; j++) {
                if (i == j) array_4[i][j] = 1;
                if (i + j == array_4.length - 1) array_4[i][j] = 1;
                System.out.print(array_4[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void numberMulByTwo(int[] array_3) {
        System.out.print("Массив с умножением на 6: ");
        for (int count3 = 0; count3 < array_3.length; count3++) {
            if (array_3[count3] < 6) {
                array_3[count3] *= 2;

            }
            System.out.print(array_3[count3] + " ");
        }
    }

    private static void fillArray(int[] array_2) {
        System.out.print("Заполнить массив: ");
        for (int count2 = 0, n = 0; count2 < array_2.length; count2++, n += 3) {
            array_2[count2] = n;
            System.out.print(array_2[count2] + " ");
        }
    }

    //Метод для печати одномерного массива
    private static void printCurrentArray(int[] array_1) {
        System.out.print(Arrays.toString(array_1));
    }

    //Метод для печати двумерного массива
    public static void printCurrentArray(int[][] arr) {
        System.out.print(Arrays.toString(arr));
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }*/
    }

    private static void replaceZeroToOne(int[] array_1) {
        System.out.print("Массив с перестановкой: ");
        for (int count1 = 0; count1 < array_1.length; count1++) {
            if (array_1[count1] == 0) {
                array_1[count1] = 1;
            } else {
                array_1[count1] = 0;
            }
            System.out.print(array_1[count1] + " ");
        }
    }


}
