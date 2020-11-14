/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author catha
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        char [][] board = {{' ','|', ' ', '|', ' '},
            {'-','+', '-', '+', '-'},
            {' ','|', ' ', '|', ' '},
            {'-','+', '-', '+', '-'},
            {' ','|', ' ', '|', ' '}};
        
        
        
        
        
        while(true){
           Scanner scan = new Scanner(System.in);
           System.out.println("Enter your move (1-9)");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)){
                System.out.println("position taken! Enter a Correct Move");
                playerPos = scan.nextInt();
            }
        
        
            placeS(board, playerPos, "player");
        
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPositions)){
                cpuPos = rand.nextInt(9) + 1;
                
            }
            placeS(board, cpuPos, "cpu");


            printBoard(board); 
            
            String result = checkWinner();
            System.out.println(result);
        }
       
    }
    
    public static void printBoard(char[][] board){
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
        
    }
    
    public static void placeS(char[][] board, int pos, String user) {
        
        char symbol = ' '; 
        
        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        }else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        
         switch(pos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    
    public static String checkWinner() {
        
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
         List dag1 = Arrays.asList(1, 5, 9);
        List dag2 = Arrays.asList(3, 5, 7);
        
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(dag1);
        winning.add(dag2);
        
        for(List l : winning){
            if(playerPositions.containsAll(l)) {
                return "Congradulations You Win!!";
            }else if(cpuPositions.containsAll(l)) {
                return "Computer Wins";
            }else if(playerPositions.size() + cpuPositions.size() == 9){
                return "Game Over DRAW";
            }
        }
        
        return "";
    }
}
    

