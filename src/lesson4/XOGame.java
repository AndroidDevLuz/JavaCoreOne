package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    public static char[][] map;
    public static  int [] blockWinTurn = new int[2];
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final int DOTS_PRE_WIN = 3;

    public static final int blocksX = SIZE - DOTS_TO_WIN +1;
    public static final int blocksY = SIZE - DOTS_TO_WIN +1;

    public static final int isWinblocksX = SIZE - 3 + 1;
    public static final int isWinblocksY = SIZE - 3 + 1;
    public static final int winBlocksInMap = blocksX * blocksY;


    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {


        initMap();
        printMap();
        while (true) {
            //Ход человека
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            //Ход компьютера

            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");

    }

    public static boolean checkWin(char symb) {

        for (int xOffset = 0; xOffset < 2; xOffset++) {
            for (int yOffset=0; yOffset < 2 ; yOffset++) {
                if(checkDiagonals(symb, xOffset, yOffset) || checkLines(symb, xOffset, yOffset)) return true;
            }
        }

        return false;
    }

    private static boolean checkDiagonals(char symb, int xOffset, int yOffset) {

        boolean leftUpRightDownDiagonals = true;
        boolean leftDownRightUpDiagonals = true;
        for (int i=0; i < DOTS_TO_WIN; i++) {

            //Немного переменных для наглядности. Чтобы видеть как мы двигаемся по диагоналям
            int x1 = i+xOffset ;
            int y1 = i+yOffset;
            int x2 = i+xOffset;
            int y2 = 3-i+yOffset;

            //Символы в диагоналях
            char leftUpRight = map[i+xOffset][i+yOffset];
            char leftDown = map[i+xOffset][3-i+yOffset];

            leftUpRightDownDiagonals &= (map[i+xOffset][i+yOffset] == symb);
            leftDownRightUpDiagonals &= (map[i+xOffset][3-i+yOffset] == symb);
        }

        return leftUpRightDownDiagonals || leftDownRightUpDiagonals;
    }

    private static boolean checkLines(char symb, int xOffset, int yOffset) {
        boolean columns, lines;
        for (int column = xOffset; column < DOTS_TO_WIN + xOffset; column++) {
            columns = true;
            lines = true;
            for (int line = yOffset; line < DOTS_TO_WIN + yOffset; line++ ) {
                columns &= (map[column][line] == symb);
                lines &= (map[line][column] == symb);
            }

            if(columns || lines) return true;
        }

        return false;
    }




    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }



    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }


    public static void aiTurn() {
        int x, y;
        //Ход  компьютера. Если есть выигрышный ход, тогда ходим с блокировкой, если нет ходим рандомно
        if(isWinTurn(DOT_X)){
            int x1 = blockWinTurn[0];
            int y1 = blockWinTurn[1];
            System.out.println("Компьютер блокирует ваш ход и  походил в точку " + (blockWinTurn[0] + 1) + " " + (blockWinTurn[1] + 1));
            map[blockWinTurn[0]][blockWinTurn[1]] = DOT_O;
            //System.out.println("Компьютер блокирует ваш ход и  походил в точку " + (blockWinTurn[0] + 1) + " " + (blockWinTurn[1] + 1));
        } else {

            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;

        }

        /*do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;*/


    }

    private static boolean isWinTurn(char symb) {

        for (int xOffset = 0; xOffset < isWinblocksX; xOffset++) {

            for (int yOffset=0; yOffset < isWinblocksX; yOffset++) {
               if(checkWinDiagonals(symb, xOffset, yOffset)) return true; //|| checkWinLines(symb, xOffset, yOffset)) return true;
            }
        }

        return false;
    }

    private static boolean checkWinLines(char symb, int xOffset, int yOffset) {

        boolean columns;
        boolean lines;

        for (int column = xOffset; column < DOTS_PRE_WIN+xOffset; column++) {
            columns = true;
            lines = true;
            for (int line = yOffset; line < DOTS_PRE_WIN + yOffset; line++ ) {

                int x1 = column;
                int y1 = line;
                char symVol = map[line][column];
                columns &= (map[line][column] == symb);
                //lines &= (map[line][column] == symb);
            }

            if(columns){
                System.out.println("Колонка человека может победить");
                if(isCellValid(column,yOffset-1)) {
                    blockWinTurn[0] = column;
                    blockWinTurn[1] = yOffset-1;
                } else if(isCellValid(column,yOffset+DOTS_PRE_WIN+1)){
                    blockWinTurn[0] = column;
                    blockWinTurn[1] = yOffset+DOTS_PRE_WIN+1;
                } else {
                    columns = false;
                }
            }

            /*if(lines){
                if(isCellValid(xOffset+DOTS_PRE_WIN+1, yOffset)) {
                    blockWinTurn[0] = xOffset+DOTS_PRE_WIN+1;
                    blockWinTurn[1] = yOffset;
                } else if(isCellValid(xOffset-1, yOffset)){
                    blockWinTurn[0] = xOffset-1;
                    blockWinTurn[1] = yOffset;
                } else {
                    lines = false;
                }
            }*/

            if(columns) return true;
        }
        return false;
    }

    private static boolean checkWinDiagonals(char symb, int xOffset, int yOffset) {
        boolean leftUpRightDownDiagonals = true;
        boolean leftDownRightUpDiagonals = true;
        for (int i=0; i < DOTS_PRE_WIN; i++) {

            leftUpRightDownDiagonals &= (map[i+xOffset][i+yOffset] == symb);
            leftDownRightUpDiagonals &= (map[i+xOffset][2-i+yOffset] == symb);

        }

        if(leftUpRightDownDiagonals){
            System.out.println("Диагональ Lup человека может победить");
            if(isCellValid(xOffset+DOTS_PRE_WIN,yOffset+DOTS_PRE_WIN)) {
                blockWinTurn[0] = xOffset+DOTS_PRE_WIN;
                blockWinTurn[1] = yOffset+DOTS_PRE_WIN;
            } else if(isCellValid(xOffset-1,yOffset-1)){
                blockWinTurn[0] = xOffset-1;
                blockWinTurn[1] = yOffset-1;
            } else {
                leftUpRightDownDiagonals = false;
            }
        }

        if(leftDownRightUpDiagonals){
            System.out.println("Диагональ Ldown человека может победить");
            if(isCellValid(xOffset+DOTS_PRE_WIN,yOffset-1)) {
                int x = xOffset+DOTS_PRE_WIN;
                int y = yOffset;
                blockWinTurn[0] = xOffset+DOTS_PRE_WIN;
                blockWinTurn[1] = yOffset-1;
            } else if(isCellValid(xOffset,yOffset+DOTS_PRE_WIN)){
                blockWinTurn[0] = xOffset;
                blockWinTurn[1] = yOffset+DOTS_PRE_WIN;
            } else {
                leftDownRightUpDiagonals = false;
            }
        }

        return leftUpRightDownDiagonals || leftDownRightUpDiagonals;
    }

}
