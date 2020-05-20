package lesson2_level2;

import lesson2_level2.exceptions.MyArrayDataException;
import lesson2_level2.exceptions.MyArraySizeException;

public class Main {

    private final static int ARRAY_SIZE1 = 4;
    private final static int ARRAY_SIZE2 = 4;

    public static void main(String[] args) {

        //Сумма массива равна 40
        String [][] stringArray = new String[][] {
                {"1","1","1","1"},
                {"2","2","2","2"},
                {"3","3","3","3"},
                {"4","4","4","4"}
        };
        //Ошибка в элементе [2][3]
        String [][] stringArrayWithChar = new String[][] {
                {"1","1","1","1"},
                {"2","2","2","2"},
                {"3","3","3","badChar"},
                {"4","4","4","4"}
        };
        //Ошибка размера массива
        String [][] stringArrayWithWrongSize = new String[][] {
                {"1","1","1","1"},
                {"2","2","2","2"},
                {"3","3","3","3"},
                {"4","4","4","4","4"}
        };

        try{
            transformAndSum(stringArray);
            //transformAndSum(stringArrayWithChar);
            //transformAndSum(stringArrayWithWrongSize);
        } catch (MyArraySizeException | MyArrayDataException  e){
            System.out.println(e.getMessage());
        }

    }

    private static void transformAndSum(String[][] stringArray) throws MyArraySizeException, MyArrayDataException {
        int size1;
        int size2= stringArray.length;
        int Sum = 0;
        if(size2!=ARRAY_SIZE2){
            throw new MyArraySizeException(String.format("Размер массива не равен %d, а равен %d", ARRAY_SIZE1, size2));
        }

        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                Sum+=getIntFromString(stringArray[i][j], i,j);
                size1=stringArray[i].length;
                if(size1!= ARRAY_SIZE1){
                    throw new MyArraySizeException(String.format("Размер массива не равен %d, а равен %d", ARRAY_SIZE1, size1));
                }
            }
        }
        System.out.println("Сумма всех элементов в массиве_"+Sum);
    }

    private static int getIntFromString(String s, int i, int j) throws MyArrayDataException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            throw new MyArrayDataException(String.format("В ячейке [%d][%d] лежат неправильные данные", i,j));
        }
    }

}
