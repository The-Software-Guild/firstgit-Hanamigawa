/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.service;

/**
 *
 * @author tianqi.zhu
 */
public class ItemSoldOutException extends Exception {

    public ItemSoldOutException(String message) {
        super(message);
    }

    public ItemSoldOutException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
