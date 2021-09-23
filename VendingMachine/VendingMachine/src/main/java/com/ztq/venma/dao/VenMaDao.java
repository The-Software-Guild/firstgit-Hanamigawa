/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ztq.venma.dao;

import com.ztq.venma.dto.Item;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zwhet
 */
public interface VenMaDao {
    
    List<Item> getAllItems();

    public Map<Item, Integer> getAllItemsQty();

    public int getQty(Item item);

    public void minusOne(Item item);
    
    public void save();
}
