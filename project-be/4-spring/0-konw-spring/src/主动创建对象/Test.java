package 主动创建对象;

public class Test {
    public static void main(String[] args) {
        JuiceMaker juiceMaker = new JuiceMaker();
        juiceMaker.setWater("开水");
        juiceMaker.setFruit("苹果");
        juiceMaker.setSugar("100g");
        String juice = juiceMaker.makeJuice();
        System.out.println(juice);
    }
}
