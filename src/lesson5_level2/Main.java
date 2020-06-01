package lesson5_level2;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        firstMethod();
        secondMethod();

    }

    private static void secondMethod() {
        float[] arr2 = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Arrays.fill(arr2, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);

        System.out.println("Время разбивки массива на два "+ (System.currentTimeMillis() - a)+ " мс");
        Thread potok1 = new Thread(()->{
            long a11 = System.currentTimeMillis();
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr2, 0, h);
            System.out.println("Время заполнения и склейки первого массива "+ (System.currentTimeMillis() - a11)+ " мс");
        });
        Thread potok2 = new Thread(()->{
            long a22 = System.currentTimeMillis();
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr2, h, h);
            System.out.println("Время заполнения и склейки второго массива "+ (System.currentTimeMillis() - a22)+ " мс");
        });
        potok1.start();
        potok2.start();
    }

    private static void firstMethod() {
        float[] arr = new float[size];
        //Заполнение единицами
        Arrays.fill(arr, 1);
        getКRunTime(arr);

    }

    private static void getКRunTime(float[] arr) {
        long a = System.currentTimeMillis();
        for(int i=0; i < arr.length;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время установления значений в массиве "+(System.currentTimeMillis() - a)+" мс");
    }
}
