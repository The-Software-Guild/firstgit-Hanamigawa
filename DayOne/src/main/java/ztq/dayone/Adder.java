/**
 *
 * @author zwhet
 * email: zwhether@gmail.com
 * Date: Sep 8 2011
 * Purpose: first NetBean project
 */
package ztq.dayone;

import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        int sum = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Please input a number to be added: (enter nothing to stop)");
            String line = scanner.nextLine();
            if (line.length() == 0) break;
            try {
                int num = Integer.parseInt(line);
                sum += num;
            } catch (NumberFormatException ne) {
                System.out.println("Plean input valid integer number!");
            }
        }
        
        System.out.printf("The total sum is %d", sum);
    }
}
