package object_adapter;

import object_adapter.adapter.PrintBanner;
import object_adapter.need_interface.Print;

public class Main {
    public static void main(String[] args) {
        String str = "abc";
        Print print = new PrintBanner(str);
        print.printWeak();
        print.printString();
    }
}
