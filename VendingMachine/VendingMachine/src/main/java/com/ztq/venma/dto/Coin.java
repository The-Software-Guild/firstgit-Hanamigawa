/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tianqi.zhu
 */
public enum Coin {
    Quater, Dime, Nickle, Cent;
    
    public Map<Coin, Integer> countCoins(int money) {
        Map<Coin, Integer> map = new HashMap<>();
        while (money >= 25) {
            map.put(Quater, map.getOrDefault(Quater, 0));
            money -= 25;
        }
        while (money >= 10) {
            map.put(Dime, map.getOrDefault(Dime, 0));
            money -= 25;
        }
        while (money >= 5) {
            map.put(Nickle, map.getOrDefault(Nickle, 0));
            money -= 25;
        }
        map.put(Cent, money);
        return map;
    }
}
