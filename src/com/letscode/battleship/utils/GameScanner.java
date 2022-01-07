package com.letscode.battleship.utils;

import java.util.Scanner;

public class GameScanner {

    private final static Scanner scan = new Scanner(System.in);

    public static String enterName(){
        System.out.print("So first please enter your name: ");
        return scan.nextLine();
    }

    public static int enterShipNumber(){
        return scan.nextInt();
    }

    public static int[]getUserCoordinates(int gameBoardLength){
        int row = 0;
        int col;
        do{
            System.out.print("Row: ");

            String rowAlphabet = new Scanner(System.in).next().toUpperCase();

            switch (rowAlphabet) {
                case "A":
                    row = 0;
                    break;
                case "B":
                    row = 1;
                    break;
                case "C":
                    row = 2;
                    break;
                case "D":
                    row = 3;
                    break;
                case "E":
                    row = 4;
                    break;
                case "F":
                    row = 5;
                    break;
                case "G":
                    row = 6;
                    break;
                case "H":
                    row = 7;
                    break;
                case "I":
                    row = 8;
                    break;
                case "J":
                    row = 9;
                    break;
            }

        } while (row < 0 || row > gameBoardLength + 1);

        do{
            System.out.print("Col: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLength + 1);

        return new int[]{row, col};
    }

}