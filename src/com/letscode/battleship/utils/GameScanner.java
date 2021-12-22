package com.letscode.battleship.utils;
import java.util.Scanner;

public class GameScanner {

    private static Scanner scan = new Scanner(System.in);

    public static void startGame(){
        System.out.println("Hi! Let's play battleship!");
    }

    public static String enterName(){
        System.out.print("So first please enter your name:");
        return scan.nextLine();
    }

    public static void greetings(String playerName){
        System.out.println("Nice to meet you " + playerName);
    }

    public static int enterShipNumber(){
        System.out.println("Now enter the number of ships you want to add to the game board.");
        return scan.nextInt();
    }

}
