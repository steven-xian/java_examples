import java.time.*;
import java.time.temporal.*;

public class LocalDates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        LocalDate sonBirthDay = LocalDate.of(2012, 10, 22);
        System.out.println("son birthday: " + sonBirthDay);
        System.out.println("son birthDay: " + LocalDate.of(2012, Month.OCTOBER, 22));

        System.out.println("until birthDay: " + sonBirthDay.until(today));
        System.out.println("until birthDAy: " + sonBirthDay.until(today, ChronoUnit.DAYS));

        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));

        DayOfWeek startOf = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOf: " + startOf);
        System.out.println(startOf.plus(2).getValue());
        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }
}
