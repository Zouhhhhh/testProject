package com.kuang.demo01;

public class Client {
    public void test1() {
        //房东要出租房子
        Host host = new Host();
        //代理，中介帮房东出租房子，但是代理角色会有一些附属操作（收中介费）
        Proxy proxy = new Proxy(host);

        //不用面对房东，直接找中介租房即可
        proxy.rent();

    }
}
