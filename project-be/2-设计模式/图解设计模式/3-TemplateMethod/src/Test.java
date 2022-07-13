public class Test {
    public static void main(String[] args) {
        AbstractDisplay display = new CharDisplay('a');
        display.display();

        display = new StringDisplay("hello world");
        display.display();
    }
}
