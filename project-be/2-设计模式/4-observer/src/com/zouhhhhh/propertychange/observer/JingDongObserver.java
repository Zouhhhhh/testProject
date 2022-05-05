package com.zouhhhhh.propertychange.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author zouhao
 * @date 2022/5/5
 */
public class JingDongObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String newProduct = (String) evt.getNewValue();
        System.err.println(String.format("发送新产品【%s】同步到京东商城", newProduct));
    }
}
