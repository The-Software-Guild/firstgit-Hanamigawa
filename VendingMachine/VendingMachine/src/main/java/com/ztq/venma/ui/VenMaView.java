/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.ui;

import com.ztq.venma.dto.Coin;
import com.ztq.venma.dto.Item;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author tianqi.zhu
 */
public class VenMaView {
    UserIO io = new UserIOConsoleImpl();

    public VenMaView(UserIO io) {
        this.io = io;
    }
    
    
    public int mainMenu(Map<Integer, Item> menuOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int mainMenu() {
        io.print("==== Main Menu ====");
        io.print("1. Feed in Money");
        io.print("2. Show Catalog");
        io.print("3. Exit");
        return io.readInt("Please choose one: ", 1, 3);
    }

    /**
     * show catalog, let user pick one
     * the input catlog must not have 0 as a key
     * @param catlog
     * @return the item the user picked
     * return null if user pick nothing
     */
    public Item showCatalog(Map<Integer, Item> catlog) {
        if (catlog.isEmpty()) {
            io.print("We don't have anything to sell. Sorry.");
            return null;
        }
        io.print("We have these products available: ");
        io.print("#0. Buy Nothing.");
        for (int i = 1; i <= catlog.size(); i++) {
            Item item = catlog.get(i);
            io.print(String.format("#%d. %s $%s", i, item.getName(), item.getPrice().toString()));
        }
        int itemOrder = io.readInt("Please choose the good you want: ", 0, catlog.size());
        return catlog.get(itemOrder);
    }

    // get user input money
    public BigDecimal getMoneyInput() {
        return io.readBig("Please feed money: ", 0, 1000);
    }

//    public void showChanges(int[] changes) {
//        io.print("Here is your change: ");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public void showChanges(Map<Coin, Integer> changes) {
        io.print("Here is your changes: ");
        for (Coin coin : Coin.values()) {
            io.print(coin.toString() + " : " + changes.get(coin));
        }
        io.readString("Hit enter to conitnue...");
    }

    public void showPurchaseDone(Item item) {
        io.print("You have bought " + item.getName() + ". Purchase done!");
    }

    public void showPurchaseFail(String message) {
        io.print("Purchase failed due to: " + message);
    }

    public void sayGoodBye() {
        io.print("Good bye!");
    }

    public void showMoneyPoll(BigDecimal curMoney) {
        io.print("You currently have $" + curMoney.toString());
    }

}
