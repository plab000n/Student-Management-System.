import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskUtility {
    // কাজ যোগ করার সময় বর্তমান সময় দেখানোর জন্য
    public static String getCurrentTimestamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    // টেক্সটকে সুন্দর করে সাজানোর জন্য
    public static void printSeparator() {
        System.out.println("------------------------------------------");
    }
}
