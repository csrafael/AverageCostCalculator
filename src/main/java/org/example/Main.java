package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<InventoryCost> inventoryCostList = InventoryCost.createInventory();
        Map<String, BigDecimal> resultMap = AverageCostCalculator.calculate(inventoryCostList);

        System.out.println("AverageCostCalculator");
        System.out.println(resultMap.toString());
    }
}