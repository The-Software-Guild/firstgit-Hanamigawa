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
public class BestAdderEver {
    public static void main(String[] args) {
        int a = 20;
        int b = 15;
        int c = 10;
        String pattern = "%d + %d + %d = %d";
        System.out.printf(pattern, a, b, c, a + b + c);
    }
}
