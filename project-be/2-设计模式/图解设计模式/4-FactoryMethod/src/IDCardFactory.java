import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {

    private List<IDCard> idCardList = new ArrayList<>();

    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    public void registerProduct(Product p) {
        System.out.println("注册ID卡： " + ((IDCard) p).getName());
    }

    public List<IDCard> getIdCardList() {
        return idCardList;
    }
}
