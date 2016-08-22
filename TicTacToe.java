package javaapplication2;

import java.util.Scanner;

public class tttGame 
{
    static final String PLAYER1 = "X";
    static final String PLAYER2 = "O";
    static final String EMPTY = "-";
    
    static String[][] board = new String[3][3];
    
    static int turn = 0;
    
    static public void init() {    
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = new String(EMPTY);
            }
        }
    }
    
    static public void getMove(int row, int col) {
        if (board[row][col].equals(EMPTY)) 
        {
            board[row][col] = (turn % 2 == 0 ? PLAYER1 : PLAYER2);
            turn++;
        }
    }
    
    static public void printBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static public String winner() 
    {
        for (int i = 0; i < board.length; i++) {
            /** check horizontally */
            if (board[i][0].equals(board[i][1]) &&
                board[i][0].equals(board[i][2])) {
                if (!board[i][0].equals(EMPTY)) {
                    return board[i][0];
                }
            }
            /** check vertically */
            if (board[0][i].equals(board[1][i]) &&
                board[0][i].equals(board[2][i])) {
                if (!board[0][i].equals(EMPTY)) {
                    return board[0][i];
                }
            }
        }
        
        /** check diagonally */
        if (board[0][0].equals(board[1][1]) &&
            board[0][0].equals(board[2][2])) {
            if (!board[0][0].equals(EMPTY)) {
                return board[0][0];
            }
        }
        if (board[0][2].equals(board[1][1]) &&
            board[0][2].equals(board[2][0])) {
            if (!board[0][2].equals(EMPTY)) {
                return board[0][2];
            }
        }
        return EMPTY;
    }
    
    static public void main(String[] args) {
        init();
        Scanner keyboard = new Scanner(System.in);
        do 
        {
            System.out.print("ENTER ROW: ");
            int row = keyboard.nextInt();
            System.out.print("ENTER COLOMN: ");
            int column = keyboard.nextInt();
            getMove((row-1), (column-1));
            printBoard();
        } while(winner().equals(EMPTY));
        
        System.out.println("PLAYER " + ((turn - 1) % 2 + 1) + " WINS!!");
    }
}