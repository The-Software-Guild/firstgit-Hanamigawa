/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author tianqi.zhu
 */
public class UserIOConsoleImpl implements UserIO {
    
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int num = -1;
        try {
            num = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Wrong input! ");
            num = -1;
        } 
        return num;
    }

    /**
     * Read a int from io with range [min, max]
     * @param prompt the prompt message for input
     * @param min 
     * @param max
     * @return 
     */
    @Override
    public int readInt(String prompt, int min, int max) {
        int num = readInt(prompt);
        while (num < min || num > max) {
            num = readInt(prompt);
        }
        return num;
    }

    /**
     * read a string from io
     * @param prompt
     * @return 
     */
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    
    public BigDecimal readBig(String prompt) {
        print(prompt);
        BigDecimal big;
        try {
            big = new BigDecimal(scanner.nextLine());
            return big.setScale(2, RoundingMode.HALF_UP);
        } catch (Exception e) {
            print("Wrong input!");
            return null;
        }
    }
    
    @Override
    public BigDecimal readBig(String prompt, int min, int max) {
        BigDecimal big = null;
        do {
            big = readBig(prompt);
        } while (big == null);
        return big;
    }

}
