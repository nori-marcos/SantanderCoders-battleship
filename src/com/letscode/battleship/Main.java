package com.letscode.battleship;

import com.letscode.battleship.utils.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Printer.startGame();
        String playerName = GameScanner.enterName();

        Printer.greetings(playerName);

        int shipNumber = GameScanner.enterShipNumber();

        GameBoardPlayer playerGameBoard = new GameBoardPlayer();
        GameBoardComputer computerGameBoard = new GameBoardComputer();

        Printer.printGame(playerName, computerGameBoard.gameBoard);

        int unknownShipNumber = computerGameBoard.getShipNumber();

        while (unknownShipNumber > 0){
            int[] guessCoordinates = getUserCoordinates(computerGameBoard.getGameBoardLength());

            char locationViewUpdate = computerGameBoard.evaluateGuessAndGetTarget(guessCoordinates, computerGameBoard.gameBoard, computerGameBoard.getShip(), computerGameBoard.getWater(), computerGameBoard.getHit(), computerGameBoard.getMiss());

            if(locationViewUpdate == computerGameBoard.getHit()){
                unknownShipNumber--;
            }

            computerGameBoard.gameBoard = computerGameBoard.updateGameBoard(computerGameBoard.gameBoard, guessCoordinates, locationViewUpdate);
            Printer.printGame("Computador", computerGameBoard.gameBoard);

        }
        System.out.println("You won!");
    }

    private static int[]getUserCoordinates(int gameBoardLength){
        int row;
        int col;
        do{
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        }while (row < 0 || row > gameBoardLength + 1);

        do{
            System.out.print("Col: ");
            col = new Scanner(System.in).nextInt();
        }while (col < 0 || row > gameBoardLength + 1);

        return new int[]{row - 1, col - 1};
    }
}
