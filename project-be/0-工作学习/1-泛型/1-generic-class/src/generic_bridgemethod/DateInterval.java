package generic_bridgemethod;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {
    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    public DateInterval() {
    }

    public DateInterval(LocalDate first, LocalDate second) {
        super(first, second);
    }
}
