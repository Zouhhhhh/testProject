package 被动创建对象;

public class Test {
    public static void main(String[] args) {
        JuiceMaker2 juiceMaker2 = ctx.getBean("juiceMaker2");
        String juice = juiceMaker2.makeJuice();
    }
}
