import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        ZonedDateTime sonBirth = ZonedDateTime.of(2012, 10, 22, 11, 45, 0, 0, ZoneId.of("Asia/Shanghai"));
        String formatted = DateTimeFormatter.ISO_DATE_TIME.format(sonBirth);
        System.out.println(formatted);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        formatted = formatter.format(sonBirth);
        System.out.println(formatted);
        formatted = formatter.withLocale(Locale.FRENCH).format(sonBirth);
        System.out.println(formatted);
        formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        formatted = formatter.format(sonBirth);
        System.out.println(formatted);

        LocalDate sonBirthday = LocalDate.parse("2012-10-22");
        System.out.println("son birthday: " + sonBirthday);

        ZonedDateTime sonBirthdaytime = ZonedDateTime.parse("2012-10-22 11:45:00-0400", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
        System.out.println("son birth: " + sonBirthdaytime);

        for (DayOfWeek w : DayOfWeek.values())
            System.out.print(w.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " ");
    }
}
