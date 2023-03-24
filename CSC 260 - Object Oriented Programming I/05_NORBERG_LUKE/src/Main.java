/*
TIC-TAC-TOE

This is a command-line implementation of the classic tic-tac-toe game, where the user plays
against a computer that uses algorithms to make intelligent moves. The game is built in Java

To play the game, the user enters the coordinates of the empty space they want to mark with
their symbol (X).The computer responds with its own move (O), which is determined by a set
of rules that make it play intelligently and strategically. The game continues until one
player wins, or the board is filled without a winner.

CSC 260
Luke Norberg
 */

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        boolean gameIsRestarting = true;
        // Start Game!

        while (gameIsRestarting) {

            // defines variables
            Scanner input = new Scanner(System.in);
            int numOfComputerMoves = 0;
            boolean gameOn = true;
            // 1 represents the X game piece, the game piece of the user and 2 represents the O game piece, the game piece of the computer
            int user = 1;
            int computer = 2;
                // main game board
            int[][] gameBoardMatrix = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };
            gameBoard(gameBoardMatrix);
            // asks user if they would like themselves or the computer to start the game
            border();
            System.out.println("Who do you want to start the game?");
            System.out.println("1. User");
            System.out.println("2. Computer");
            border();

            int whoStartsGame = input.nextInt();
            if (whoStartsGame == 2) {
                numOfComputerMoves += computerMove(gameBoardMatrix, whoStartsGame, numOfComputerMoves);
            }

            // main game loop
            while (gameOn) {
                gameBoard(gameBoardMatrix);
                // checks if a user has won
                int checkWin = checkWin(gameBoardMatrix);
                if (checkWin == 3) {
                    gameIsRestarting = false;
                    break;
                } else if (checkWin == 4) {
                    gameOn = false;
                    continue;
                }
                // prompts the user to enter the row and column of where they'd like to place their piece
                // user can restart the game by entering R
                System.out.println("Enter a cell using two numbers, or enter R to restart the game");
                String userCells = input.next();
                if (userCells.toUpperCase().charAt(0) == 'R') {
                    gameOn = false;
                    continue;
                }
                if (userCells.length() < 2) {
                    System.out.println("Please make sure you give two numbers");
                    continue;
                }
                // grabs the row number and column number
                int row = Integer.parseInt(String.valueOf(userCells.charAt(0)));
                int column = Integer.parseInt(String.valueOf(userCells.charAt(1)));
                // checks validity of the user's row and column number input
                boolean inputIsCorrect = checkUserInput(gameBoardMatrix, row, column);
                if (inputIsCorrect) {
                    // once validity is checked the user's piece is placed on the board
                    gameBoardMatrix[row - 1][column - 1] = user;
                    gameBoard(gameBoardMatrix);
                } else {
                    System.out.println("Please enter a valid row and column");
                    continue;
                }
                checkWin = checkWin(gameBoardMatrix);
                if (checkWin == 3) {
                    gameIsRestarting = false;
                    break;
                } else if (checkWin == 4) {
                    gameOn = false;
                    continue;
                }
                // computer's move
                numOfComputerMoves += computerMove(gameBoardMatrix, whoStartsGame, numOfComputerMoves);
                // provides a 5-second pause to simulate the computer "thinking"
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void gameBoard(int[][] game) {
        // function to output the game board to the console
        String border = "|---|---|---|";
        String boardSpace = "";
        System.out.println(border);
        for (int row = 0; row < game.length; row++) {
            for (int column = 0; column < game[row].length; column++) {
                // appends each empty square or player's piece by checking the matrix values in gameBoardMatrix (line 27)
                boardSpace += "|" + gamePiece(game[row][column]);

            }
            System.out.println(boardSpace + "|");
            System.out.println(border);
            boardSpace = "";
        }
        System.out.print("\n");
    }

    public static String gamePiece(int matrixNumber) {
        // formula for which player number equals which piece. If there is no player number, it returns an empty space
        if (matrixNumber == 1) return " X ";
        if (matrixNumber == 2) return " O ";
        else return "   ";
    }

    public static void border() {
        // border for clean console output
        System.out.println("----------------------------------------");
    }

    public static boolean checkUserInput(int[][] gameBoard, int row, int column) {
        // checks that the row and column entered by the user are between 1 and 3 and makes sure the given row and column space is empty
         if ( (row < 1 || row > 3) || (column < 1 || column > 3) ) return false;
        else if (gameBoard[row - 1][column - 1] != 0) return false;
        else return true;
    }

    // oh boy get ready...

    public static int computerMove(int[][] gameBoard, int whoStartsGame, int move) {
        // This function uses the board so the computer can intelligently play its move
        Random random = new Random();
        int wherePieceGoes = 0;

        // if the computer starts the game, they'll pick either the middle or a random corner space
        if (whoStartsGame == 2 && move == 0) {
            wherePieceGoes = random.nextInt(5);
            switch (wherePieceGoes) {
                case 0:
                    gameBoard[0][0] = 2;
                    break;
                case 1:
                    gameBoard[2][0] = 2;
                    break;
                case 2:
                    gameBoard[0][2] = 2;
                    break;

                case 3:
                    gameBoard[2][2] = 2;
                    break;
                case 4:
                    gameBoard[1][1] = 2;
                    break;
            }
            return 1;
        // if the user starts the game and the user doesn't pick the center, the computer will pick the middle space
        } else if (whoStartsGame == 1 && gameBoard[1][1] == 0 && move == 0) {
            gameBoard[1][1] = 2;
            return 1;
            // if the user starts the game and does pick the center, the computer will pick a random corner space
        } else if (whoStartsGame == 1 && move == 0) {
            wherePieceGoes = random.nextInt(4);
            switch (wherePieceGoes) {
                case 0: gameBoard[0][0] = 2; break;
                case 1: gameBoard[2][0] = 2; break;
                case 2: gameBoard[0][2] = 2; break;
                case 3: gameBoard[2][2] = 2; break;
            }
            return 1;
        } else {
        // checks first if the computer only needs one space to win and if so plays it.
        // then checks if user only needs one space to win and then blocks it

            // cycles through the opponents, starting with the computer
            for (int player = 2; player >= 1; player--) {
                for (int j = 0; j < gameBoard.length; j++) {
                    int numsInColumn = 0;
                    int[] zeroInRowIndex = {-1, -1};
                    int numsInRow = 0;
                    int[] zeroInColumnIndex = {-1, -1};
                    int numsInDiagonal1 = 0;
                    int[] zeroInDiagonal1Index = {-1, -1};
                    int numsInDiagonal2 = 0;
                    int[] zeroInDiagonal2Index = {-1, -1};

                    // calculates how many of the pieces and how many blank spaces are in a row/column/diagonal
                    // saves the row and column index of an empty space to win/block the user's win

                    for (int i = 0; i < gameBoard[j].length; i++) {
                        // calculates # of pieces and blank spaces for column
                        if (gameBoard[i][j] == player) numsInColumn++;
                        if (gameBoard[i][j] == 0) {
                        // saves index of blank space
                            zeroInRowIndex[0] = i;
                            zeroInRowIndex[1] = j;
                        }
                        // calculates # of pieces and blank spaces for row
                        if (gameBoard[j][i] == player) numsInRow++;
                        if (gameBoard[j][i] == 0) {
                        // saves index of blank space
                            zeroInColumnIndex[0] = j;
                            zeroInColumnIndex[1] = i;
                        }
                    }

                    // checks diagonals for these conditions
                    for (int i = 0; i < 3; i++) {
                        // calculates # of pieces and blank spaces for first diagonal
                        if (gameBoard[i][i] == player) numsInDiagonal1++;
                        if (gameBoard[i][i] == 0) {
                        // saves index of blank space
                            zeroInDiagonal1Index[0] = i;
                            zeroInDiagonal1Index[1] = i;
                        }
                        // calculates # of pieces and blank spaces for second diagonal
                        if (gameBoard[i][2 - i] == player) numsInDiagonal2++;
                        if (gameBoard[i][2 - i] == 0) {
                        // saves index of blank space
                            zeroInDiagonal2Index[0] = i;
                            zeroInDiagonal2Index[1] = (2 - i);
                        }
                    }

                    // if there is two of the same pieces and one empty space in a row/column/diagonal, the computer places the piece there
                    if (numsInColumn >= 2 && zeroInRowIndex[0] != -1) {
                        gameBoard[zeroInRowIndex[0]][zeroInRowIndex[1]] = 2;
                        return 1;
                    }
                    else if (numsInRow >= 2 && zeroInColumnIndex[0] != -1) {
                        gameBoard[zeroInColumnIndex[0]][zeroInColumnIndex[1]] = 2;
                        return 1;
                    }
                    else if (numsInDiagonal1 >= 2 && zeroInDiagonal1Index[0] != -1) {
                        gameBoard[zeroInDiagonal1Index[0]][zeroInDiagonal1Index[1]] = 2;
                        return 1;
                    }
                    else if (numsInDiagonal2 >= 2 && zeroInDiagonal2Index[0] != -1) {
                        gameBoard[zeroInDiagonal2Index[0]][zeroInDiagonal2Index[1]] = 2;
                        return 1;
                    }
                }
            }

            // if the computer picked the centerpiece and doesn't have two in a row, the computer will pick a space next to the center

            wherePieceGoes = random.nextInt(2);
            if (gameBoard[1][1] == 2) {
                // each if statement checks if the whole row/column/diagonal doesn't contain the player's piece

                // checks center column
                if (gameBoard[0][1] == 0 && gameBoard[2][1] == 0) {
                    switch (wherePieceGoes) {
                        case 0: gameBoard[0][1] = 2; break;
                        case 1: gameBoard[2][1] = 2; break;
                    }
                    return 1;
                }

                // checks center row
                else if (gameBoard[1][0] == 0 && gameBoard[1][2] == 0) {
                    switch (wherePieceGoes) {
                        case 0: gameBoard[1][0] = 2; break;
                        case 1: gameBoard[1][2] = 2; break;
                    }
                    return 1;
                }

                // checks first diagonal
                else if (gameBoard[0][0] == 0 && gameBoard[2][2] == 0) {
                    switch (wherePieceGoes) {
                        case 0: gameBoard[0][0] = 2; break;
                        case 1: gameBoard[2][2] = 2; break;
                    }
                    return 1;
                }

                // checks second diagonal
                else if (gameBoard[0][2] == 0 && gameBoard[2][0] == 0) {
                    switch (wherePieceGoes) {
                        case 0: gameBoard[0][2] = 2; break;
                        case 1: gameBoard[2][0] = 2; break;
                    }
                    return 1;
                }
            } else {
                // if the computer's first piece is in a corner, the following selects an adjacent square which row/column/diagonal
                // doesn't contain the player's piece
                boolean cornerCasesTest = false;

                // checks top left corner
                if (gameBoard[0][0] == 2) {
                    cornerCasesTest = cornerCases(gameBoard, new int[]{0, 1}, new int[]{0, 2});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 0}, new int[]{2, 0});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 1}, new int[]{2, 2});
                    if (cornerCasesTest) return 1;

                // checks top right corner
                } else if (gameBoard[0][2] == 2) {
                    cornerCasesTest = cornerCases(gameBoard, new int[]{0, 1}, new int[]{0, 0});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 2}, new int[]{2, 2});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 1}, new int[]{2, 0});
                    if (cornerCasesTest) return 1;

                // checks bottom left corner
                } else if (gameBoard[2][0] == 2) {
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 0}, new int[]{0, 0});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{2, 1}, new int[]{2, 2});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 1}, new int[]{0, 2});
                    if (cornerCasesTest) return 1;

                // checks bottom right corner
                } else if (gameBoard[2][2] == 2) {
                    cornerCasesTest = cornerCases(gameBoard, new int[]{2, 1}, new int[]{2, 0});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 2}, new int[]{0, 2});
                    if (cornerCasesTest) return 1;
                    cornerCasesTest = cornerCases(gameBoard, new int[]{1, 1}, new int[]{0, 0});
                    if (cornerCasesTest) return 1;
                }
            }

            // as a last resort, the computer will select the first open square available
            for (int i = 0; i < gameBoard.length; i++) {
                for (int j = 0; j < gameBoard[i].length; j++) {
                    if (gameBoard[i][j] == 0)  {
                        gameBoard[i][j] = 2;
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean cornerCases(int[][] gameBoard, int[] user1, int[] user2) {
        // for corner pieces, checks if the rest of the row, column, or diagonal is empty
        // if so, randomly places the computer's piece in one of the free spaces
        Random random = new Random();
        int wherePieceGoes = random.nextInt(2);
        // checks if the spaces are empty
        if (gameBoard[user1[0]][user1[1]] == 0 && gameBoard[user2[0]][user2[1]] == 0) {
            switch(wherePieceGoes) {
                case 0: gameBoard[user1[0]][user1[1]] = 2; break;
                case 1: gameBoard[user2[0]][user2[1]] = 2; break;
            }
            return true;
        }
        return false;
    }

    public static int checkWin(int[][] gameBoard) {
        Scanner input = new Scanner(System.in);
        // checks the board to see if either opponent has won

        // loops through both the X's and O's to see if either opponent has won
        for (int player = 1; player < 3; player++) {
            // this loop checks any rows or columns of the game board
            for (int j = 0; j < gameBoard.length; j++) {
                int numInRow = 0;
                int numInColumn = 0;
                // for the given row or column of the game board, it checks if each number is the current opponent's game piece
                for (int i = 0; i < gameBoard[j].length; i++) {
                    if (gameBoard[i][j] == player) numInRow++;
                    if (gameBoard[j][i] == player) numInColumn++;
                }
                // if all the numbers in the row or column are the current opponent's number we return that opponent as the winner
                if (numInRow == 3 || numInColumn == 3) {
                    System.out.println((player == 1) ? "YOU WIN!!!!!" : "Computer wins :,(");
                    // checks if the user wants to play again
                    System.out.println("Would you like to play again?");
                    char playAgain = input.next().toLowerCase().charAt(0);
                    if (playAgain == 'n') return 3;
                    if (playAgain == 'y') return 4;
                }
            }

            // this code checks the diagonals of the game board
            // (1, 1), (2, 2), (3, 3) on the game board
            int numOfDiagonal1 = 0;
            // (3, 3), (2, 2), (1, 1) on the game board
            int numOfDiagonal2 = 0;
            // for each diagonal, checks if it has the given opponent's game piece
            for (int i = 0; i < 3; i++) {
                if (gameBoard[i][i] == player) numOfDiagonal1++;
                if (gameBoard[i][2 - i] == player) numOfDiagonal2++;
            }
            // if either diagonal has all three of the given opponent's game piece, that opponent wins
            if (numOfDiagonal1 == 3 || numOfDiagonal2 == 3) {
                System.out.println((player == 1) ? "YOU WIN!!!!!" : "Computer wins :,(");
                // checks if the user wants to play again
                System.out.println("Would you like to play again?");
                char playAgain = input.next().toLowerCase().charAt(0);
                if (playAgain == 'n') return 3;
                if (playAgain == 'y') return 4;
            }
        }

        // checks if the opponent's have tied
        int numOfZeros = 0;
        for (int[] row : gameBoard) {
            for (int space : row) {
                if (space == 0) numOfZeros++;
            }
        }
        if (numOfZeros == 0) {
            System.out.println("Draw");
            // checks if the user wants to play again
            System.out.println("Would you like to play again?");
            char playAgain = input.next().toLowerCase().charAt(0);
            if (playAgain == 'n') return 3;
            if (playAgain == 'y') return 4;
        }

        return 0;
    }
}