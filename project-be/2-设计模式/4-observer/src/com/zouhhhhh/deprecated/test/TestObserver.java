package com.zouhhhhh.deprecated.test;

import com.zouhhhhh.deprecated.observeable.ProductList;
import com.zouhhhhh.deprecated.observer.JingDongObserver;
import com.zouhhhhh.deprecated.observer.TaoBaoObserver;

public class TestObserver {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        productList.addProductListObserver(new JingDongObserver());
        productList.addProductListObserver(new TaoBaoObserver());
        productList.addProduct("垃圾袋");
    }
}
