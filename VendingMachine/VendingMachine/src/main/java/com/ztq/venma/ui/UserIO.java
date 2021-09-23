/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.ui;

import java.math.BigDecimal;

/**
 *
 * @author tianqi.zhu
 */
public interface UserIO {
    void print(String msg);

    int readInt(String prompt);

    /**
     * Given prompt word, read an int in the range [min, max]
     * @param prompt
     * @param min
     * @param max
     * @return 
     */
    int readInt(String prompt, int min, int max);

    String readString(String prompt);

    public BigDecimal readBig(String please_feed_money_, int i, int i0);
    
}
