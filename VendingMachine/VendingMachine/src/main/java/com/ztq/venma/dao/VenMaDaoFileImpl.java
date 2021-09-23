/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.dao;

import com.ztq.venma.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tianqi.zhu
 */
public class VenMaDaoFileImpl implements VenMaDao{
    
    String DEFAULTFILE = "Warehouse.txt";
    String PATH = "./";
    String DELIMITER = "::";
    Map<Item, Integer> allItemsQty;
    public VenMaDaoFileImpl() throws VenMaDaoIOException {
        allItemsQty = loadFromFile();
    }
    
    /**
     * for test use only
     * @throws VenMaDaoIOException 
     */
    public VenMaDaoFileImpl(String testFile) throws VenMaDaoIOException {
        DEFAULTFILE = testFile;
        allItemsQty = loadFromFile();
    }
    
    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(allItemsQty.keySet());
    }

    @Override
    public Map<Item, Integer> getAllItemsQty() {
        return allItemsQty;
    }

    @Override
    public int getQty(Item item) {
        return allItemsQty.get(item);
    }

    /**
     * reduce one in quantity from dao
     * @param item 
     */
    @Override
    public void minusOne(Item item)  {
//        if (!allItemsQty.containsKey(item)) {
//            throw VenMaDaoIOException("Item not exist");
//        }
//        if (allItemsQty.get(item) == 0) {
//            throw VenMaDaoIOException("The item is sold out.");
//        }
        allItemsQty.put(item, allItemsQty.get(item) - 1);
    }

    /**
     * unmarshall all records in file, load to memory
     * @return Map<Item, Integer> key is item, value is quantity
     */
    private Map<Item, Integer> loadFromFile() throws VenMaDaoIOException {
        Scanner scanner; // create scanner
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DEFAULTFILE)));
        } catch (FileNotFoundException e) {
            throw new VenMaDaoIOException("Default File not Found.");
        }
        
        // initialize map
        Map<Item, Integer> map = new HashMap<>();
        while(scanner.hasNextLine()) {
            String[] record = scanner.nextLine().split(DELIMITER);
            Item item = new Item(record[0], new BigDecimal(record[1])); // first two in records are about item
            int qty = Integer.parseInt(record[2]);
            map.put(item, qty);
        }
        return map;
    }
    
    private void saveToFile() throws VenMaDaoIOException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DEFAULTFILE));
        } catch (IOException e) {
            throw new VenMaDaoIOException("Sava to File Failed!");
        }
        
        // marshall each item, qty pair
        for (Item item : allItemsQty.keySet()) {
            String name = item.getName();
            String price = item.getPrice().toString();
            String qty = allItemsQty.get(item).toString();
            out.println(name+DELIMITER+price+DELIMITER+qty);
        }
        
        out.flush();
        out.close();
    }

    @Override
    public void save() {
        try {
            saveToFile();
        } catch (VenMaDaoIOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
