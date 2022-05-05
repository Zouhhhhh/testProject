package com.zouhhhhh.observeable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author zouhao
 * @date 2022/4/29
 */
public class ProductList extends Observable {

    private static ProductList instance;

    private List<String> productList = null;

    private ProductList(){}

    /**
     * 取得唯一实例
     * @return  产品列表唯一实例
     */
    public static ProductList getInstance() {
        if (instance == null) {
            // 懒汉式
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    /**
     * 增加观察者（电商接口）
     * @param observer 观察者
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    /**
     * 新增产品
     * @param newProduct    新产品
     */
    public void addProduct(String newProduct) {
        productList.add(newProduct);
        System.err.println("产品列表增加了新产品：" + newProduct);
        this.setChanged();
        this.notifyObservers(newProduct);
    }

}
