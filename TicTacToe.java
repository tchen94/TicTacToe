package tictactoe;

import java.util.Scanner;

class TicTacToe {
    char[][] board;
    char currentTurn;
    int x;
    int o;
    int xVal;
    int yVal;
    boolean xWin;
    boolean oWin;
    boolean draw;

    TicTacToe() {
        this.board = new char[3][3];
        this.x = 0;
        this.o = 0;
        this.draw = false;
        this.xWin = false;
        this.oWin = false;
        this.currentTurn = 'X';

        System.out.println("---------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '_';
                System.out.printf("%s ", board[row][col]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
        System.out.println();
    }

    public void printBoard() {
        System.out.println("---------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.printf("%s ", board[row][col]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
        System.out.println();
        rowCheck();
        diagCheck();
        colCheck();
    }

    public void updateBoard(int first, int second) {
        switch (currentTurn) {
            case 'X':
                this.board[first - 1][second - 1] = currentTurn;
                x++;
                currentTurn = 'O';
                break;
            case 'O':
                this.board[first - 1][second - 1] = currentTurn;
                o++;
                currentTurn = 'X';
                break;
        }
    }

    public void getCoordinates() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                String playerMove = scanner.nextLine();
                String[] parts = playerMove.split(" ");
                xVal = Integer.parseInt(parts[0]);
                yVal = Integer.parseInt(parts[1]);

                if (xVal < 0 || yVal < 0 || xVal > 3 || yVal > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (board[xVal - 1][yVal - 1] == 'X' || board[xVal - 1][yVal - 1] == 'O') {
                    System.out.println("The cell is occupied! Choose another one!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            break;
        }
    }

    public void rowCheck() {
        // Checking for X win
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'X') {
                if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                    xWin = true;
                    break;
                }
            }
            // Checking for O win
            if (board[row][0] == 'O') {
                if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                    oWin = true;
                    break;
                }
            }
        }
    }

    public void colCheck() {
        // Checking for X win
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == 'X') {
                if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                    xWin = true;
                    break;
                }
            }
            // Checking for O win
            if (board[0][col] == 'O') {
                if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                    oWin = true;
                    break;
                }
            }
        }
    }

    public void diagCheck() {
        // Checking for X win in each diagonal
        if (board[0][0] == 'X') {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                xWin = true;
            }
        }
        if (board[0][2] == 'X') {
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                xWin = true;
            }
        }
        // Checking for O win in each diagonal
        if (board[0][0] == 'O') {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                oWin = true;
            }
        }
        if (board[0][2] == 'O') {
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                oWin = true;
            }
        }
    }

    public void start() {
        while (true) {
            if (xWin == true || xWin == true && x + o == board.length * board[0].length) {
                System.out.println("X wins");
                break;
            }
            if (oWin == true || oWin == true && x + o == board.length * board[0].length) {
                System.out.println("O wins");
                break;
            }
            if (x + o == board.length * board[0].length) {
                System.out.println("Draw");
                break;
            }
            getCoordinates();
            updateBoard(xVal, yVal);
            printBoard();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        // Start the program
        game.start();
    }
}
