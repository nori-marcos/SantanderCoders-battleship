package com.letscode.battleship.utils;

public class Printer {

    public static void welcome(){
        System.out.println("Hi! Let's play battleship!");
    }

    public static void greetings(String playerName){
        System.out.println("Nice to meet you dear " + playerName + "!!!");
    }

    public static void requestPlayerShipNumber(){
        System.out.print("Please, enter the number of ships you will have: ");
    }

    public static void requestComputerShipNumber(){
        System.out.print("Enter now how many ships your opponent will have: ");
    }

    public static void printGame(String player, char[][] gameBoard, char water, char ship){
        printPlayer(player);
        printGameBoard(gameBoard, water, ship);
    }
    
    public static void printLine(int length){
        String line = "";
        for(int i = 0; i < length; i++){
            line += '-';
        }
        System.out.println(line);
    }

    private static void printPlayer(String player){
        printLine(45);
        System.out.printf("                   %s                     %n", player);
        printLine(45);
    }

    private static void printGameBoard(char[][] gameBoard, char water, char ship){
        System.out.print("|   ");

        for (int i = 0; i < gameBoard.length; i++){
            System.out.print("| " + i + " ");
        }

        System.out.println("|");

        printLine(45);

        for(int row = 0; row < gameBoard.length; row++){

            switch (row){
                case 0:
                    System.out.print("| A ");
                    break;
                case 1:
                    System.out.print("| B ");
                    break;
                case 2:
                    System.out.print("| C ");
                    break;
                case 3:
                    System.out.print("| D ");
                    break;
                case 4:
                    System.out.print("| E ");
                    break;
                case 5:
                    System.out.print("| F ");
                    break;
                case 6:
                    System.out.print("| G ");
                    break;
                case 7:
                    System.out.print("| H ");
                    break;
                case 8:
                    System.out.print("| I ");
                    break;
                case 9:
                    System.out.print("| J ");
                    break;
            }

            for(int col = 0; col < gameBoard.length; col++) {

                char position = gameBoard[row][col];

                    System.out.print("| " + position + " ");

//                if(position == ship){
//                    System.out.print("| " + water + " ");
//                } else {
//                    System.out.print("| " + position + " ");
//                }
            }

            System.out.print("|");
            System.out.print("\n");
            printLine(45);

        }
    }


}
