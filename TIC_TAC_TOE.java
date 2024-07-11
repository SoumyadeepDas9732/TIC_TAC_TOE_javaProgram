package com.rohit;

import java.util.Scanner;

public class TIC_TAC_TOE {

    static char[][] playBoard(char arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 2) {
                    System.out.print(arr[i][j]);
                }else{
                    System.out.print(arr[i][j] + "|");
                }
            }
            System.out.println();
        }
        return arr;
     }
     static boolean isWon(char arr[][],char player){
        boolean isWon = false;
        //Row detection
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] ==player && arr[i][1] ==player && arr[i][2] ==player ) {
                isWon = true;
            }
        }
        //Coloum detection
        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] ==player && arr[1][i] ==player && arr[2][i] ==player ) {
                isWon = true;
            }
        }
        //Diagonal detection
            if (arr[0][0] ==player && arr[1][1] ==player && arr[2][2] ==player ) {
                isWon = true;
            }
            if (arr[0][2] ==player && arr[1][1] ==player && arr[2][0] ==player ) {
                isWon = true;
            }
        return isWon;
     }
     static boolean isEmpty(char arr[][]){
        boolean isEmpty = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != ' ') {
                    isEmpty = true;
                }else{
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
     }
     public static void main(String[] args) {
        char arr[][] = new char[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        boolean emptyShell = false;
        @SuppressWarnings("resource")
        Scanner Sc = new Scanner(System.in);
        System.out.println("Let's play the TIC TAC TOE game in java(Terminal): .......");
        while (gameOver == false || isEmpty(arr) == false) {
            playBoard(arr);
            System.out.println("Player " + player + " Move");
            int row = Sc.nextInt();
            int col = Sc.nextInt();
            if (arr[row][col] == ' ') {
                arr[row][col] = player;
                gameOver = isWon(arr, player);
                emptyShell = isEmpty(arr);
                if (emptyShell) {
                    playBoard(arr);
                    System.out.println("There is nothing any empty shell is in the play board \nRerun the code for play again...\nBetter luck next time");
                    break;
                }
                if (gameOver) {
                    playBoard(arr);
                    System.out.println("Player " + player + " has won");
                }else{
                    if (player == 'X') {
                        player = 'O';
                    }else{
                        player = 'X';
                    }
                }
            }else{
                System.out.println("Invalid move: Try again.....");
            }
        }
     }
}
