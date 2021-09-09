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
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = Integer.parseInt(scanner.nextLine());
        int max = 220 - age;
        double upper = Math.round(max * 0.85);
        double lower = Math.round(max * 0.5);
        System.out.printf("Your maximum heart rate should be %d beats per minute \n", max);
        System.out.printf("Your target HR Zone is %.0f - %.0f beats per minute", lower, upper);
    }
}
