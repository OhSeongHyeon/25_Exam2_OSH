import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppUtil {
    public static String dateTimeParser(LocalDateTime ldt) {
        return ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
