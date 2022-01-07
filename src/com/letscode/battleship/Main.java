package com.letscode.battleship;

import com.letscode.battleship.utils.*;

public class Main {
    public static void main(String[] args) {
        Printer.welcome();

        String playerName = GameScanner.enterName();
        Printer.greetings(playerName);

        Printer.requestPlayerShipNumber();
        GameBoardPlayer playerGameBoard = new GameBoardPlayer();

        Printer.requestComputerShipNumber();
        GameBoardComputer computerGameBoard = new GameBoardComputer();


        Printer.printGame(playerName, playerGameBoard.gameBoard, playerGameBoard.getWater(), playerGameBoard.getShip());

//        Printer.printGame("Computer", computerGameBoard.gameBoard);





        int unknownShipNumber = computerGameBoard.getShipNumber();

        while (unknownShipNumber > 0){
            int[] guessCoordinates = GameScanner.getUserCoordinates(computerGameBoard.getGameBoardLength());

            char locationViewUpdate = computerGameBoard.evaluateGuessAndGetTarget(guessCoordinates, computerGameBoard.gameBoard, computerGameBoard.getShip(), computerGameBoard.getWater(), computerGameBoard.getHit(), computerGameBoard.getMiss());

            if(locationViewUpdate == computerGameBoard.getHit()){
                unknownShipNumber--;
            }

            computerGameBoard.gameBoard = computerGameBoard.updateGameBoard(computerGameBoard.gameBoard, guessCoordinates, locationViewUpdate);
            Printer.printGame("Computador", computerGameBoard.gameBoard, computerGameBoard.getWater(), computerGameBoard.getShip());

        }
        System.out.println("You won!");
    }

}
