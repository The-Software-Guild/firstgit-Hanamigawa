/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ztq.venma.service;

import com.ztq.venma.dao.VenMaAuditDao;
import com.ztq.venma.dao.VenMaAuditDaoFileImpl;
import com.ztq.venma.dao.VenMaDao;
import com.ztq.venma.dao.VenMaDaoFileImpl;
import com.ztq.venma.dto.Coin;
import java.math.BigDecimal;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author zwhet
 */
public class VenMaServiceTest {
    
    VenMaService service;

    public VenMaServiceTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testWarehouseFile = "testWarehouse.txt";
        String testAuditFile = "testAudit.txt";
        VenMaDao testDao = new VenMaDaoFileImpl(testWarehouseFile);
        VenMaAuditDao auditDao = new VenMaAuditDaoFileImpl(testAuditFile);
        service = new VenMaService(testDao, auditDao);
    }
    
    @org.junit.jupiter.api.Test
    public void testGetChanges(){
        service.addMoney(new BigDecimal("1.44"));
        int moneyInCents = (int) (service.getMoneyPool().floatValue() * 100);
        System.out.print(moneyInCents);
        Map<Coin, Integer> changesBack = service.getChanges();
        System.out.print(changesBack);
        
        Coin[] keys = new Coin[]{Coin.Quater, Coin.Dime, Coin.Nickle, Coin.Cent};
        assertEquals(5, changesBack.get(Coin.Quater), "Quaters dont't match");
        assertEquals(1, changesBack.get(Coin.Dime), "Dime dont't match");
        assertEquals(1, changesBack.get(Coin.Nickle), "Nickle dont't match");
        assertEquals(4, changesBack.get(Coin.Cent), "Cent dont't match");
    }
    
}
