package com.letscode.battleship;

import com.letscode.battleship.entity.GameBoardComputer;
import com.letscode.battleship.entity.GameBoardPlayer;
import com.letscode.battleship.utils.*;

public class Main {
    public static void main(String[] args) {
        Printer.welcome();

        String playerName = GameScanner.enterName();
        Printer.nameCompliment(playerName);

        //In this game, the player can choose different number of ships for the two game boards.
        Printer.requestPlayerShipNumber();
        GameBoardPlayer playerGameBoard = new GameBoardPlayer();

        Printer.requestComputerShipNumber();
        GameBoardComputer computerGameBoard = new GameBoardComputer();

        Printer.printPlayerGame(playerName, playerGameBoard.gameBoard, playerGameBoard.getWater(), playerGameBoard.getShip());
        Printer.printComputerGame(computerGameBoard.gameBoard, computerGameBoard.getWater(), computerGameBoard.getShip());
        System.out.println("Above you can see the two game boards.");
        System.out.println("To make things easier, we've already positioned your ships.");
        System.out.println("You must have noticed that you can see only the ships positioned on your board. The reason is pretty obvious, isn't it?");
        System.out.println("In order to hit the computer's hidden boats, you need to give the coordinates of your shots.");
        System.out.println("Give a letter for the row and a number for the column. So let's get started!!");

        //This is the logic of this game.
        int playerUnknownShipNumber = playerGameBoard.getShipNumber();
        int computerUnknownShipNumber = computerGameBoard.getShipNumber();

        while (computerUnknownShipNumber > 0 && playerUnknownShipNumber > 0) {
            int[] guessCoordinatesByPlayer = GameScanner.getUserCoordinates(computerGameBoard.getGameBoardLength());
            int[] guessCoordinatesByComputer = computerGameBoard.generateCoordinates(computerGameBoard.getGameBoardLength());

            char computerLocationViewUpdate = computerGameBoard.evaluatePlayerGuessAndGetTarget(guessCoordinatesByPlayer, computerGameBoard.gameBoard, computerGameBoard.getShip(), computerGameBoard.getWater(), computerGameBoard.getHit(), computerGameBoard.getMiss());
            char playerLocationViewUpdate = playerGameBoard.evaluateComputerGuessAndGetTarget(guessCoordinatesByComputer, playerGameBoard.gameBoard, playerGameBoard.getShip(), playerGameBoard.getWater(), playerGameBoard.getHit(), playerGameBoard.getMiss());

            if(computerLocationViewUpdate == computerGameBoard.getHit()){
                computerUnknownShipNumber--;
            }

            if(playerLocationViewUpdate == playerGameBoard.getHit()){
                playerUnknownShipNumber--;
            }

            playerGameBoard.gameBoard = playerGameBoard.updatePlayerBoard(playerGameBoard.gameBoard, guessCoordinatesByComputer, playerLocationViewUpdate);
            computerGameBoard.gameBoard = computerGameBoard.updateComputerBoard(computerGameBoard.gameBoard, guessCoordinatesByPlayer, computerLocationViewUpdate);

            Printer.printPlayerGame(playerName, playerGameBoard.gameBoard, playerGameBoard.getWater(), playerGameBoard.getShip());
            Printer.printComputerGame(computerGameBoard.gameBoard, computerGameBoard.getWater(), computerGameBoard.getShip());

        }

        if(computerUnknownShipNumber == 0) {
        System.out.println("You won!");
        }

        if (playerUnknownShipNumber == 0){
        System.out.println("Computer won!");
        }
    }
}
