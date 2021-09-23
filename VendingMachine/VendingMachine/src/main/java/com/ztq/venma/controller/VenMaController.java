package com.ztq.venma.controller;

import com.ztq.venma.dao.VenMaDaoIOException;
import com.ztq.venma.dto.Item;
import com.ztq.venma.dto.Coin;
import com.ztq.venma.service.VenMaService;
import com.ztq.venma.ui.VenMaView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tianqi.zhu
 */
public class VenMaController {
    VenMaService service;
    VenMaView view;
    
    public VenMaController(VenMaService service, VenMaView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VenMaDaoIOException {
        boolean keepGoing = true;
        Map<Item, Integer> items = service.getAllItemsQty(); // Item, Quantity
        Map<Integer, Item> itemsInOrder = buildMenuOrder(items);
        while (keepGoing) {
//            view.showCatalog(itemsInOrder);
            int menuSelection = view.mainMenu();
            switch (menuSelection) {
                case 1:
                    getMoney(); // let user feed in money
                    break;
                case 2:
                    buyMenu(itemsInOrder); // show catalog and let user buy
                    break;
                case 3:
                    quitVenMa();
                    keepGoing = false;
                    break;
            }
        }
    }

//    private Map<Integer, Item> buildMenuOrder(List<Item> items) {
//        HashMap<Integer, Item> map = new HashMap<>();
//        for (int i = 0; i < items.size(); i++) {
//            map.put(i + 1, items.get(i));
//        }
//        return map;
//    }

    private Map<Integer, Item> buildMenuOrder(Map<Item, Integer> items) {
        HashMap<Integer, Item> map = new HashMap<>();
        int i = 1;
        for (Item item : items.keySet()) {
            map.put(i++, item);
        }
        return map;
    }

    private void getMoney() throws VenMaDaoIOException {
        BigDecimal curMoney = service.getMoneyPool();
        view.showMoneyPoll(curMoney);
        BigDecimal money = view.getMoneyInput();
        service.addMoney(money);
        view.showMoneyPoll(service.getMoneyPool());
    }

    private void buyMenu(Map<Integer, Item> itemsInOrder) {
        Item item = view.showCatalog(itemsInOrder);
        if (item == null) return;
        try {
            service.vend(item);
            Map<Coin, Integer> changes = service.getChanges();
            view.showPurchaseDone(item);
            view.showChanges(changes);
        } catch (Exception e) {
            view.showPurchaseFail(e.getMessage());
        }
    }

    private void quitVenMa() throws VenMaDaoIOException {
        view.showChanges(service.getChanges());
        view.sayGoodBye();
    }

   
}
