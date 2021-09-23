/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.classroster.ui;

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
    
    public double readDouble(String prompt) {
        double num  = 0;
        try {
            num = Double.parseDouble(prompt);
        } catch (NumberFormatException e) {
            print("Input Error!");
        }
        return num;
    }
    
    public double readDouble(String prompt, double min, double max) {
        double num;
        do {
            num = readDouble(prompt);
        } while (num < min || num > max);
        return num;
    }
    
    public float readFloat(String prompt, float min, float max) {
        return (float) readDouble(prompt, min, max);
    }
    
    public int readInt(String prompt) {
        return 0;
    }
    
    public int readInt(String prompt, int min, int max) {
        return (int) readDouble(prompt, min, max);
    }
    
    public long readLong(String prompt) {
        return 0;
    }
    
    public long readLong(String prompt, long min, long max) {
        return (long) readDouble(prompt, min, max);
    }
    
    public String readString(String prompt) {
        return "";
    }
}
