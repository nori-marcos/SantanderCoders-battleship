package com.letscode.battleship.utils;

import java.util.Arrays;

public class GameBoard {

    public char[][] board;

    private char water = ' ';
    private char ship = 'N';
    private char hit = '*';
    private char miss = '-';

    public GameBoard(int gameBoardLength){
        this.board = generateGameBoard(gameBoardLength);
    }

    private char[][] generateGameBoard(int gameBoardLength) {
        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard){
            Arrays.fill(row, this.water);
        }
        return gameBoard;
    }

    private void markInGameBoard(int positionRow, int positionCol, char element){
        this.board[positionRow][positionCol] = element;
    }

    private void tryShot(int positionRow, int positionCol){
        char position = this.board[positionRow][positionCol];

        if(position != this.water || position != this.ship){
            System.out.println("You've already tried this position.");
            return;
        }

        if(position == this.ship){
            this.markInGameBoard(positionRow, positionCol, this.hit);
            return;
        }

        if(position == this.water){
            this.markInGameBoard(positionRow, positionCol, this.miss);
            return;
        }
    }

    

//     private char[][] generateShipPosition(int shipNumber, char[][]gameBoard){}
}
