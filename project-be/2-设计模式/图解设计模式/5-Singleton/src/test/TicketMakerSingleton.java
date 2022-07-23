package test;

public class TicketMakerSingleton {

    private static TicketMakerSingleton ticketMakerSingleton = new TicketMakerSingleton();

    private int ticket = 1000;

    private TicketMakerSingleton () {
    }

    public static TicketMakerSingleton getInstance() {
        return ticketMakerSingleton;
    }

    public int getNextTicketNumber() {
        return ticket++;
    }
}
