package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InventoryCost {
    public String item;
    public Integer quantity;
    public BigDecimal cost;

    public InventoryCost(String item, Integer quantity, BigDecimal cost) {
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
    }

    public static List<InventoryCost> createInventory(){
        List<InventoryCost> list = new ArrayList<>();
        InventoryCost item1 = new InventoryCost("Memory 64Gb", 10, new BigDecimal(10.00d));
        InventoryCost item2 = new InventoryCost("Chipset RX2321", 20, new BigDecimal(20.00d));
        InventoryCost item3 = new InventoryCost("Memory 64Gb", 50, new BigDecimal(15.00d));
        InventoryCost item4 = new InventoryCost("Display DS21344", 100, new BigDecimal(12.00d));
        InventoryCost item5 = new InventoryCost("Chipset RX2321", 80, new BigDecimal(25.00d));

        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

        return list;
    }
}
