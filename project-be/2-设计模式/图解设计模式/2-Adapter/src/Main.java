import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO fileIO = new FileProperties();
        try {
            fileIO.readFormFile("D:\\read.txt");
            fileIO.setValue("month", "8");
            fileIO.setValue("day", "13");
            fileIO.writeToFile("D:\\write.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
