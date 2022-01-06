package com.letscode.battleship.utils;

public class Printer {

    public static void startGame(){
        System.out.println("Hi! Let's play battleship!");
    }

    public static void greetings(String playerName){
        System.out.println("Nice to meet you " + playerName + "!!!");
    }

    public static void printGame(String player, char[][] gameBoard){
        printPlayer(player);
        printGameBoard(gameBoard);
    }
    
    public static void printLine(int length){
        String line = "";
        for(int i = 0; i < length; i++){
            line += '-';
        }
        System.out.println(line);
    }

    private static void printPlayer(String player){
        printLine(62);
        System.out.printf("                           %s                             %n", player);
        printLine(62);
    }

    private static void printGameBoard(char[][] gameBoard){
        printLine(62);
        for (char[] row : gameBoard){
            for(char column : row){
                System.out.print("|  "  + column + "  ");
            }
            System.out.print("|");
            System.out.print("\n");
            printLine(62);
        }
    }
}
