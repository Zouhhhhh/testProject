package generic_bridgemethod;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        DateInterval interval = new DateInterval(LocalDate.of(2021, 1, 1), LocalDate.of(2022, 12, 12));
        Pair<LocalDate> pair = interval;
        pair.setSecond(LocalDate.of(2022,3,4));
    }
}
