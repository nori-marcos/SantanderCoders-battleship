package com.letscode.battleship.utils;

public class GameBoardComputer extends GameBoard {

    public static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
        return gameBoard;
    }

    public static char evaluateGuessAndGetTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss){
        String message;
        int row =guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];

        if (target == ship){
            message = "Hit!";
            target = hit;
        } else if (target == water){
            message = "Water!";
            target = miss;
        } else {
            message = "Already hit!";
        }
        System.out.println(message);
        return target;
    }
}
