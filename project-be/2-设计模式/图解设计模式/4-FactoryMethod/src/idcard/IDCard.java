package idcard;

import framework.Product;

public class IDCard extends Product {
    private String name;
    IDCard(String name) {
        System.out.println("制作ID卡： " + name);
        this.name = name;
    }

    @Override
    public void use() {
        System.out.println("使用ID卡： " + name);
    }

    public String getName() {
        return name;
    }

}
