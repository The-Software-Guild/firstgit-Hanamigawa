/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.dto;

/**
 * Record: an Item has how many Quantity(qty)
 * @author tianqi.zhu
 */
public class Record {
    Item item;
    int qty;

    public Record(Item item, int qty) {
        this.item = item;
        this.qty = qty;
    }
}
