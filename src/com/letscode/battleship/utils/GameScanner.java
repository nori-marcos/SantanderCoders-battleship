package com.letscode.battleship.utils;

import java.util.Scanner;

public class GameScanner {

    private static Scanner scan = new Scanner(System.in);

    public static String enterName(){
        System.out.print("So first please enter your name: ");
        return scan.nextLine();
    }

    public static int enterShipNumber(){
        System.out.print("Now enter the number of ships you want to add to the game board: ");
        return scan.nextInt();
    }


}
