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
        double[] percents = new double[5];
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            percents[i] = rd.nextFloat();
            sum += percents[i];
        }
        for (int i = 0; i < 5; i++) {
            String breed = "";
            int index = 0;
            while (breed == "") {
                index = rd.nextInt(dict.length);
                breed = dict[index];
            }
            dict[index] = ""; // whenever we fetch a breed from dict, set it to empty to avoid repeat fetch
           
            System.out.printf("%d%% %s \n", Math.round(percents[i] / sum * 100), breed);
        }
        System.out.println("Wow, that's QUIET the dog!");
    }
}
