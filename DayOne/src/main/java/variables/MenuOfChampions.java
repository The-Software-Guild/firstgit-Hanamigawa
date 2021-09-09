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
public class MenuOfChampions {


    public static void main(String[] args) {
        String food1 = "Ramen";
        float price1 = 20;
        String food2 = "Dumpling";
        float price2 = 12.5f;
        String food3 = "Gyoza";
        float price3 = 15.0f;
        
        for (int i = 0; i < 20; i++) System.out.print("= = ");
        System.out.println("\n ~~Restaurant Menu~~");
        System.out.printf("$ %.2f **** %s \n", price1, food1);
        System.out.printf("$ %.2f **** %s \n", price2, food2);
        System.out.printf("$ %.2f **** %s \n", price3, food3);
        for (int i = 0; i < 20; i++) System.out.print("= = ");
    }
}
