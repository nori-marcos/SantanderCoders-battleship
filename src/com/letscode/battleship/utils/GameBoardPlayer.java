package com.letscode.battleship.utils;

import static com.letscode.battleship.utils.GameScanner.getUserCoordinates;

public class GameBoardPlayer extends GameBoard{

    public GameBoardPlayer() {
    }

    @Override
    public char[][] placeShip(char[][] gameBoard, int shipNumber, char water, char ship) {
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;

        while (placedShips < shipNumber) {
            int[] shipLocation = getUserCoordinates(gameBoardLength);

            char playerShipPlacement = gameBoard[shipLocation[0]][shipLocation[1]];

            if (playerShipPlacement == water) {
                gameBoard[shipLocation[0]][shipLocation[1]] = ship;
                placedShips++;
            }
        }
        return gameBoard;
    }
}
