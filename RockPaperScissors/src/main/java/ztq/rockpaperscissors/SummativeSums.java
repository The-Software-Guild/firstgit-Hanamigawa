/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ztq.rockpaperscissors;

/**
 *
 * @author tianqi.zhu
 */
public class SummativeSums {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] arr2 = new int[]{ 999, -60, -77, 14, 160, 301 };
        int[] arr3 = new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
            140, 150, 160, 170, 180, 190, 200, -99 };
        
        int[][] matrix = new int[][]{arr1, arr2, arr3};
        
        for (int i = 1; i <= 3; i++) {
            int[] arr = matrix[i - 1];
            int total = sum(arr);
            System.out.printf("#%d Array Sum: %d \n", i, total);
        }
    }
    
    public static int sum(int[] array) {
        int ans = 0;
        for (int x : array) ans += x;
        return ans;
    }
}
