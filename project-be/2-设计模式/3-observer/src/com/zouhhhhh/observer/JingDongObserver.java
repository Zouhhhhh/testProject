package com.zouhhhhh.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zouhao
 * @date 2022/4/29
 */
public class JingDongObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        System.err.println(String.format("发送新产品【%s】同步到京东商城", newProduct));
    }
}
