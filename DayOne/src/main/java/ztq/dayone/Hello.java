/**
 *
 * @author zwhet
 * email: zwhether@gmail.com
 * Date: Sep 8 2011
 * Purpose: first NetBean project
 */
package ztq.dayone;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world!" + " and You!");
        System.out.println("After");
        
        for (int i = 0 ;i < 5; i++) {
            if (i == 2) i=4;
            System.out.println(i);
        }
    }
}
