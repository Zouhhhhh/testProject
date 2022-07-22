public class Test {
    public static void main(String[] args) {
        AbstractDisplay display = userA();
        display.display();

        System.out.println("=======");

        display = userB();
        display.display();
    }
    public static AbstractDisplay userA() {
        return new CharDisplay('a');
    }

    public static AbstractDisplay userB() {
        return new StringDisplay("hello world");
    }

}
