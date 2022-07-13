import org.w3c.dom.ls.LSOutput;

public class Test {

    public static void main(String[] args) {
        TicketMaker ticketMaker1 = new TicketMaker();
        TicketMaker ticketMaker2 = new TicketMaker();

        System.out.println("ticket1 :" + ticketMaker1.getNextTicketNumber());
        System.out.println("ticket1 :" + ticketMaker1.getNextTicketNumber());
        System.out.println("ticket2 :" + ticketMaker2.getNextTicketNumber());
        System.out.println("ticket1 :" + ticketMaker1.getNextTicketNumber());
        System.out.println("ticket2 :" + ticketMaker2.getNextTicketNumber());
    }

//    public static void main(String[] args) {
//        TicketMakerSingleton ticketMaker1 = TicketMakerSingleton.getInstance();
//        TicketMakerSingleton ticketMaker2 = TicketMakerSingleton.getInstance();
//
//        System.out.println("ticket1 :" + ticketMaker1.getNextTicketNumber());
//        System.out.println("ticket1 :" + ticketMaker1.getNextTicketNumber());
//        System.out.println("ticket2 :" + ticketMaker2.getNextTicketNumber());
//        System.out.println("ticket1 :" + ticketMaker1.getNextTicketNumber());
//        System.out.println("ticket2 :" + ticketMaker2.getNextTicketNumber());
//    }

}
