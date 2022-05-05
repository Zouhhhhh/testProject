package com.zouhhhhh.propertychange.observeable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/5/5
 */
public class ProductList {

    private static ProductList instance;

    private List<String> productList = null;

    private PropertyChangeSupport listeners = new PropertyChangeSupport(this);

    private ProductList(){}

    /**
     * TODO: synchronized的使用
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
     * @param listener 观察者
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.addPropertyChangeListener(listener);
    }

    /**
     * 删除观察者
     * @param listener 观察者
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listeners.removePropertyChangeListener(listener);
    }

    /**
     * 发布监听事件
     * @param prop      属性名
     * @param oldValue  旧值
     * @param newValue  新值
     */
    protected void firePropertyChange(String prop, Object newValue) {
        listeners.firePropertyChange(prop, null,  newValue);
    }

    /**
     * 新增产品
     * @param newProduct    新产品
     */
    public void addProduct(String newProduct) {
        productList.add(newProduct);
        System.err.println("产品列表增加了新产品：" + newProduct);
        firePropertyChange("newProduct", newProduct);
    }

}
