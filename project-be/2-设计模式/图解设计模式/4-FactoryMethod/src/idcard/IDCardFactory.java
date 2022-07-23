package idcard;

import framework.Factory;
import framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {

    private List owners = new ArrayList<>();

    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    public void registerProduct(Product p) {
        owners.add(((IDCard) p).getName());
    }

    public List<IDCard> getIdCardList() {
        return owners;
    }
}
