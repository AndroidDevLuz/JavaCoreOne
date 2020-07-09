package lesson6_level3;

import java.util.Arrays;

public class Main {

    /*1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив,
    который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
    Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].*/

    /*2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем
    нет хоть одной четверки или единицы, то метод вернет false;
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
            [ 1 1 1 4 4 1 4 4 ] -> true
            [ 1 1 1 1 1 1 ] -> false
            [ 4 4 4 4 ] -> false
            [ 1 4 4 1 1 4 3 ] -> false*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayHas4(new int[]{1, 3, 4, 5})));
        System.out.println(Arrays.toString(arrayHas4(new int[]{1, 3, 5, 5, 4,8,9,3})));

        System.out.println(arrayContains1and4(new int[]{1,3,4,5}));
        System.out.println(arrayContains1and4(new int[]{8,3,4,1}));
        System.out.println(arrayContains1and4(new int[]{4,9,4,1}));
    }


    public static int[] arrayHas4(int[] arr){
        for (int i = arr.length -1; i >=0; i--) {
            if(arr[i] == 4){
                return Arrays.copyOfRange(arr, i+1, arr.length);
            }
        }
        throw new RuntimeException("В массиве нет 4-ки");
    }


    public static boolean arrayContains1and4(int[] arr){
        boolean is1exist = false;
        boolean is4exist = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 1 && arr[i] !=4){
                return false;
            }
            if(arr[i] == 1){
                is1exist = true;
            }
            if(arr[i] ==4){
                is4exist = true;
            }
        }
        return is1exist & is4exist;

    }




}
