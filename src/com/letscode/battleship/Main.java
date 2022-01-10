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
        Printer.printPlayerGame(playerName, playerGameBoard.gameBoard);
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

            //"Evaluate" methods check the guesses made by the player and the computer. Depending on the situation, the method may return "hit", "water" or "repeated hit". The return is used as reference to update the game board.
            char computerLocationViewUpdate = computerGameBoard.evaluatePlayerGuessAndGetTarget(guessCoordinatesByPlayer, computerGameBoard.gameBoard, computerGameBoard.getShip(), computerGameBoard.getWater(), computerGameBoard.getHit(), computerGameBoard.getMiss());
            char playerLocationViewUpdate = playerGameBoard.evaluateComputerGuessAndGetTarget(guessCoordinatesByComputer, playerGameBoard.gameBoard, playerGameBoard.getShip(), playerGameBoard.getWater(), playerGameBoard.getHit(), playerGameBoard.getMiss());

            //The following conditionals are used to check what has been returned by the previous methods. The number of undetected ships decreases if the target is equal to "hit".
            //Each instantiated game board has a parameter of "hit".
            if(computerLocationViewUpdate == computerGameBoard.getHit()){
                computerUndetectedShipNumber--;
            }

            if(playerLocationViewUpdate == playerGameBoard.getHit()){
                playerUndetectedShipNumber--;
            }

            //Both  game boards are updated according to the result of "Evaluate" methods.
            playerGameBoard.gameBoard = playerGameBoard.updatePlayerBoard(playerGameBoard.gameBoard, guessCoordinatesByComputer, playerLocationViewUpdate);
            computerGameBoard.gameBoard = computerGameBoard.updateComputerBoard(computerGameBoard.gameBoard, guessCoordinatesByPlayer, computerLocationViewUpdate);

            //After each update, the game boards are printed.
            Printer.printPlayerGame(playerName, playerGameBoard.gameBoard);
            Printer.printComputerGame(computerGameBoard.gameBoard, computerGameBoard.getWater(), computerGameBoard.getShip());
        }

        //Final conditionals to check who zeroed the number of undetected ships first .
        if(computerUndetectedShipNumber == 0) {
        System.out.println("You won!");
        }

        if (playerUndetectedShipNumber == 0){
        System.out.println("Computer won!");
        }
    }
}
