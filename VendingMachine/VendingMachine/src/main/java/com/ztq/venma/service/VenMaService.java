/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.service;

import com.ztq.venma.dao.VenMaAuditDao;
import com.ztq.venma.dao.VenMaDao;
import com.ztq.venma.dao.VenMaDaoIOException;
import com.ztq.venma.dto.Coin;
import static com.ztq.venma.dto.Coin.Cent;
import static com.ztq.venma.dto.Coin.Dime;
import static com.ztq.venma.dto.Coin.Nickle;
import static com.ztq.venma.dto.Coin.Quater;
import com.ztq.venma.dto.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tianqi.zhu
 */
public class VenMaService {
    VenMaDao dao;
    VenMaAuditDao auditDao;
    BigDecimal moneyPool;
    
    public VenMaService(VenMaDao dao, VenMaAuditDao auditDao) throws VenMaDaoIOException {
        this.dao = dao;
        this.auditDao = auditDao;
        moneyPool = new BigDecimal("0");
        moneyPool = moneyPool.setScale(2);
        auditDao.writeAuditEnty("Vending Machine Started.");
    }

    public Map<Item, Integer> getAllItemsQty() {
        return dao.getAllItemsQty();
    }

    public void addMoney(BigDecimal money){
        moneyPool = moneyPool.add(money);
        auditDao.writeAuditEnty("$" + money.toString() + " addded. In total: $" + moneyPool.toString());
    }

    /**
     * vend the item, if could not, throw exceptions
     * @param item
     * @throws MoneyShortException
     * @throws ItemSoldOutException 
     */
    public void vend(Item item) throws MoneyShortException, ItemSoldOutException{
        if (item.getPrice().compareTo(moneyPool) > 0) {
            throw new MoneyShortException(String.format("You didn't feed enough money to buy %s", item.getName()));
        }
        if (dao.getQty(item) == 0) {
            throw new ItemSoldOutException("The item is sold out.");
        }
        dao.minusOne(item);
        moneyPool = moneyPool.subtract(item.getPrice());
        auditDao.writeAuditEnty(item.getName() + " sold for $" + item.getPrice());
    }

    /**
     * clear money pool, produce changes in for of map
     * @return 
     */
    public Map<Coin, Integer> getChanges() {
        // initialize the result map
        Map<Coin, Integer> map = new HashMap<>();
        for (Coin coin : Coin.values()) map.put(coin, 0);
        
        int moneyInCents = (int) (moneyPool.floatValue() * 100);
        while (moneyInCents >= 25) {
            map.put(Coin.Quater, map.get(Quater) + 1);
            moneyInCents -= 25;
        }
        while (moneyInCents >= 10) {
            map.put(Dime, map.get(Dime) + 1);
            moneyInCents -= 10;
        }
        while (moneyInCents >= 5) {
            map.put(Nickle, map.get(Nickle) + 1);
            moneyInCents -= 5;
        }
        map.put(Cent, moneyInCents);
        auditDao.writeAuditEnty("Changes returned to customer: $" + moneyPool.toString());
        moneyPool = BigDecimal.ZERO;
        return map;
    }

    public BigDecimal getMoneyPool() {
        return moneyPool;
    }

}
