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

        //When it receives the number of ships, the program prints the game boards of the player and of the computer.
        Printer.printPlayerGame(playerName, playerGameBoard.gameBoard, playerGameBoard.getWater(), playerGameBoard.getShip());
        Printer.printComputerGame(computerGameBoard.gameBoard, computerGameBoard.getWater(), computerGameBoard.getShip());
        Printer.printInstructions();

        //Both players start with the number of undetected ships equal the number before set by the player.
        int playerUndetectedShipNumber = playerGameBoard.getShipNumber();
        int computerUndetectedShipNumber = computerGameBoard.getShipNumber();

        //The block of code will repeat as the number of undetected number of the player and of the computer is above zero. The code block is terminated when one of them equals zero.
        while (computerUndetectedShipNumber > 0 && playerUndetectedShipNumber > 0) {

            //Player' guesses are obtained by scanning.
            int[] guessCoordinatesByPlayer = GameScanner.getUserCoordinates(computerGameBoard.getGameBoardLength());

            //Computer's guesses are generated randomly according to the board game length. This method can generate repeated coordinates.
            int[] guessCoordinatesByComputer = computerGameBoard.generateCoordinates(computerGameBoard.getGameBoardLength());


            char computerLocationViewUpdate = computerGameBoard.evaluatePlayerGuessAndGetTarget(guessCoordinatesByPlayer, computerGameBoard.gameBoard, computerGameBoard.getShip(), computerGameBoard.getWater(), computerGameBoard.getHit(), computerGameBoard.getMiss());
            char playerLocationViewUpdate = playerGameBoard.evaluateComputerGuessAndGetTarget(guessCoordinatesByComputer, playerGameBoard.gameBoard, playerGameBoard.getShip(), playerGameBoard.getWater(), playerGameBoard.getHit(), playerGameBoard.getMiss());

            if(computerLocationViewUpdate == computerGameBoard.getHit()){
                computerUndetectedShipNumber--;
            }

            if(playerLocationViewUpdate == playerGameBoard.getHit()){
                playerUndetectedShipNumber--;
            }

            playerGameBoard.gameBoard = playerGameBoard.updatePlayerBoard(playerGameBoard.gameBoard, guessCoordinatesByComputer, playerLocationViewUpdate);
            computerGameBoard.gameBoard = computerGameBoard.updateComputerBoard(computerGameBoard.gameBoard, guessCoordinatesByPlayer, computerLocationViewUpdate);

            Printer.printPlayerGame(playerName, playerGameBoard.gameBoard, playerGameBoard.getWater(), playerGameBoard.getShip());
            Printer.printComputerGame(computerGameBoard.gameBoard, computerGameBoard.getWater(), computerGameBoard.getShip());
        }

        if(computerUndetectedShipNumber == 0) {
        System.out.println("You won!");
        }

        if (playerUndetectedShipNumber == 0){
        System.out.println("Computer won!");
        }
    }
}
