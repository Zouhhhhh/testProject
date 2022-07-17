package class_adapter;

import class_adapter.need_interface.Print;
import class_adapter.adapter.PrintBanner;

public class Main {
    public static void main(String[] args) {
        String str = "abc";
        Print print = new PrintBanner(str);
        print.printWeak();
        print.printString();
    }
}
