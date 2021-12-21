package com.letscode.battleship;


import com.letscode.battleship.utils.Printer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int gameBoardLength = 10;
        char water = '-';
        char ship = 'N';
        char hit = '*';
        char miss = '-';
        int shipNumber = 3;

        char[][] gameBoard = generateGameBoard(gameBoardLength, ship, shipNumber, water);

        Printer.printGame("Player",gameBoard);

    }

    private static char[][] generateGameBoard(int gameBoardLength, char ship, int shipNumber, char water) {
        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];

        for (char[] row : gameBoard){
            Arrays.fill(row,water);
        }

        return gameBoard;
    }
}
