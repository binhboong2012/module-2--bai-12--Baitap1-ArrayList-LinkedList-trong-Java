package com.codegym;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getPrice() - product2.getPrice() > 0) {
            return 1;
        } else if (product1.getPrice() - product2.getPrice() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
