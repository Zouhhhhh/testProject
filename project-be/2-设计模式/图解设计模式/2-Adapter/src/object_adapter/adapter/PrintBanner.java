package object_adapter.adapter;

import object_adapter.need_interface.Print;
import object_adapter.real_class.Banner;

public class PrintBanner extends Print{

    private Banner banner;

    public PrintBanner(String string) {
        banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printString() {
        banner.showWithAster();
    }
}
