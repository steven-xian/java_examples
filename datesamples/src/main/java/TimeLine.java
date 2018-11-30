import java.time.*;
import java.util.*;
import java.util.stream.*;

public class TimeLine {
    public static void main(String[] args) {
        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();

        Duration timeElasped = Duration.between(start, end);
        long millis = timeElasped.toMillis();
        System.out.printf("%d milliseconds\n", millis);

        Instant start2 = Instant.now();
        runAlgorithm2();
        Instant end2 = Instant.now();
        Duration timeElapsed2 = Duration.between(start2, end2);
        System.out.printf("%d milliseconds\n", timeElapsed2.toMillis());
        boolean overTenTimesFaster = timeElasped.multipliedBy(10).minus(timeElapsed2).isNegative();
        System.out.printf("The first algo is %smore than ten times faster", overTenTimesFaster ? "" : "not ");
    }

    public static void runAlgorithm() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
        System.out.println("before:");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("after");
        System.out.println(list);
    }

    public static void runAlgorithm2() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
        System.out.println("before:");
        System.out.println(list);
        while (!IntStream.range(1, list.size()).allMatch(i -> list.get(i - 1).compareTo(list.get(i)) <= 0)) {
            Collections.shuffle(list);
            System.out.printf("shuffle:");
            System.out.println(list);
        }
        System.out.println("after");
        System.out.println(list);
    }
}
