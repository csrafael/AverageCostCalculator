package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageCostCalculator {
    public static Map<String, BigDecimal> calculate(List<InventoryCost> inventoryCosts) {
        Map<String, BigDecimal> mapTotalCost = new HashMap<>();
        Map<String, BigDecimal> mapTotalAmount = new HashMap<>();
        Map<String, BigDecimal> mapAverageCost = new HashMap<>();

        for (InventoryCost inventoryCost : inventoryCosts) {
            BigDecimal amount = new BigDecimal(inventoryCost.quantity);
            BigDecimal cost =  inventoryCost.cost.multiply(amount);

            if (mapTotalAmount.containsKey(inventoryCost.item)) {
                BigDecimal newAmount = mapTotalAmount.get(inventoryCost.item).add(amount);
                mapTotalAmount.put(inventoryCost.item,newAmount);
            } else {
                mapTotalAmount.put(inventoryCost.item,amount);
            }

            if (mapTotalCost.containsKey(inventoryCost.item)) {
                BigDecimal newCost = mapTotalCost.get(inventoryCost.item).add(cost);
                mapTotalCost.put(inventoryCost.item,newCost);
            } else {
                mapTotalCost.put(inventoryCost.item,cost);
            }

            if (!mapAverageCost.containsKey(inventoryCost.item)) {
                mapAverageCost.put(inventoryCost.item, BigDecimal.ZERO);
            }
        }

        for (String item : mapAverageCost.keySet()) {
            BigDecimal avg = mapTotalCost.get(item).divide(mapTotalAmount.get(item),2, RoundingMode.HALF_UP);
            mapAverageCost.put(item,avg);
        }

        return mapAverageCost;
    }
}
