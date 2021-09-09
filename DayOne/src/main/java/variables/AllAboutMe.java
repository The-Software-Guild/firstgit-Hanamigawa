/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package variables;

/**
 *
 * @author tianqi.zhu
 */
public class AllAboutMe {
    public static void main(String[] args) {
        String name = "Tianqi";
        String food = "Ramen";
        int pet = 2;
        String home = "silo";
        boolean know = false;
        String pattern = "My name is %s.\n" +
        "My favorite %s is hot buttered gnocchi.\n" +
        "I have %d pets.\n" +
        "I live in a %s under the sea, and I love it here.\n" +
        "It is %b I know how to whistle.";
        System.out.printf(pattern, name, food, pet, home, know);
    }
}
