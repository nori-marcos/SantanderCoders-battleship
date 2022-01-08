package com.letscode.battleship.entity;

public class GameBoardComputer extends GameBoard {

    public GameBoardComputer() {
    }

    public char[][] updateComputerBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
        return gameBoard;
    }

    public char evaluatePlayerGuessAndGetTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss){
        String message;
        int row =guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];

        if (target == ship){
            message = "You hit a ship!";
            target = hit;
        } else if (target == water){
            message = "You hit the water!";
            target = miss;
        } else {
            message = "You've already hit this point!";
        }
        System.out.println(message);
        return target;
    }

}
