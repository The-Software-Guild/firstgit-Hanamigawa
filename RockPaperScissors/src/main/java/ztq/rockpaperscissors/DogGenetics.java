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
public class DogGenetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of your dog?");
        String name = scanner.nextLine();
        System.out.println("I have a gene report of " + name + " here.");
        Random rd = new Random();
        String[] dict = new String[]{"Dragon", "St. Bernard", "Chihuahua", "Panda", "Lion", "Godzilla", "Crane", "Golden Retriever"};
        System.out.println(name + " is:");
        Set<String> used = new HashSet<>();
        int total = 95;
        int toFive = 0;
        while (toFive < 5) {
            int index = rd.nextInt(dict.length);
            String breed = dict[index];
            if (used.contains(breed)) continue;
            used.add(breed);
            toFive++;
            int percentage = rd.nextInt(total);
            total -= percentage;
            total += 1; // in case the first breeds used up all 100, we add 1 each time
            percentage += 1;
            System.out.printf("%d%% %s \n", percentage, breed);
        }
        System.out.println("Wow, that's QUIET the dog!");
    }
}
