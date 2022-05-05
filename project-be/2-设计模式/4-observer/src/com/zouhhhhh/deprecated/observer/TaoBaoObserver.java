package com.zouhhhhh.deprecated.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zouhao
 * @date 2022/4/29
 */
public class TaoBaoObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        System.err.println(String.format("发送新产品【%s】同步到淘宝商城", newProduct));
    }
}
