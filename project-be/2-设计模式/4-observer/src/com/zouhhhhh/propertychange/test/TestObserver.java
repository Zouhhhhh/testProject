package com.zouhhhhh.propertychange.test;


import com.zouhhhhh.propertychange.observeable.ProductList;
import com.zouhhhhh.propertychange.observer.JingDongObserver;
import com.zouhhhhh.propertychange.observer.TaoBaoObserver;

/**
 * @author zouhao
 * @date 2022/5/5
 */
public class TestObserver {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        productList.addPropertyChangeListener(new JingDongObserver());
        productList.addPropertyChangeListener(new TaoBaoObserver());
        productList.addProduct("快乐水");
    }
}
