/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ztq.rockpaperscissors;

import java.util.*;
/**
 *
 * @author tianqi.zhu
 */
public class RockPaperScissors {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Rock, Paper, Scissors game!");
        while (true) {
            System.out.println("How many rounds do you want to play?");
            int round;
            try {
                round = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Game end.");
                break;
            }
            
            if (round < 1 || round > 10) {
                System.out.println("You can only play 1 - 10 rounds");
                break;
            }
            game(round);
            
            System.out.println("Do you still want to play? y for yes, other answer for no");
            String again = scanner.nextLine();
            if (again.equals("y") || again.equals("Y")) {
                continue;
            } else {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }
    
    private static void game(int round) {
        int lose = 0;
        int win = 0;
        int tie = 0;
        Random rd = new Random();
        String[] dict = new String[]{"", "Rock", "Paper", "Scissors"};
        while (round > 0) {
            System.out.println("Please enter your move 1:Rock, 2:Paper, 3:Scissors:");
            String input = scanner.nextLine();
            try {
                int move = Integer.parseInt(input);
                assert(move >= 1 && move <= 3);
                int computer = rd.nextInt(3) + 1;
                System.out.printf("Your move is %s, and computer's move is %s.\n", dict[move], dict[computer]);
                if (move == computer) {
                    System.out.println("It's a tie. ");
                    tie++;
                } else if (move - computer == 1 || move - computer == -2) {
                    win++;
                    System.out.println("You win!");
                } else {
                    lose++;
                    System.out.println("You lose!");
                }
                round--;
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
            System.out.printf("%d rounds left. \n", round);
        }
        System.out.printf("In total %d rounds: you win %d, you lose %d, and we tie %d. \n \n", lose + win + tie, win, lose, tie);
    }
}
