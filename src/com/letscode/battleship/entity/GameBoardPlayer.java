package com.letscode.battleship.entity;

public class GameBoardPlayer extends GameBoard{

    public GameBoardPlayer() {
    }

    public char[][] updatePlayerBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
        return gameBoard;
    }

    public char evaluateComputerGuessAndGetTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss){

        String message;
        int row =guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];

        if (target == ship){
            message = "Computer hit your boat!";
            target = hit;
        } else if (target == water){
            message = "Computer hit the water!";
            target = miss;
        } else {
            message = "Computer was confused and repeated the shot!";
        }
        System.out.println(message);
        return target;
    }
}
