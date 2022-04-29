package com.zouhhhhh.test;

import com.zouhhhhh.observeable.ProductList;
import com.zouhhhhh.observer.JingDongObserver;
import com.zouhhhhh.observer.TaoBaoObserver;

public class TestObserver {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        productList.addProductListObserver(new JingDongObserver());
        productList.addProductListObserver(new TaoBaoObserver());
        productList.addProduct("垃圾袋");
    }
}
