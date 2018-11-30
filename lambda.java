import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import java.time.ZoneId;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.lang.annotation.Repeatable;
import java.util.stream.Collectors;
import java.util.stream.Collector;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class lambda {
    public static void main(String[] args) {
        List<String> students = Arrays.asList("johnny", "peter", "mike", "tom");

        System.out.println("before sort:");
        System.out.println(students);

        Collections.sort(students, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        System.out.println("after sort:");
        System.out.println(students);

        Collections.sort(students, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(students);

        Collections.sort(students, (String a, String b) -> b.compareTo(a));
        System.out.println(students);

        Collections.sort(students, (a, b) -> b.compareTo(a));
        System.out.println(students);

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter.convert("213123");
        System.out.println(converted2);

        FirstLetter firstLetter = new FirstLetter();
        Converter<String, String> converter3 = firstLetter::startsWith;
        String converted3 = converter3.convert("Java");
        System.out.println(converted3);

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Johnny");
        System.out.println(person.firstName + " " + person.lastName);

        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("steven"));
        System.out.println(predicate.negate().test("hello"));

        Consumer<Person> greeter = (p) -> System.out.println("Hello " + p.firstName);
        greeter.accept(new Person("Steven", "Xian"));

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd");
        stringCollection.add("aaa");
        stringCollection.add("bbb");
        stringCollection.add("aaabbb");
        stringCollection.add("ccc");
        stringCollection.add("ddd222");
        stringCollection.add("bbbccc");
        stringCollection.add("cccddd");

        stringCollection
                .stream()
                .sorted()
                .map(String::toUpperCase)
                //.filter((s) -> s.startsWith("c"))
                .forEach(System.out::println);

        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // long t0 = System.nanoTime();
        // long count = values.stream().sorted().count();
        // System.out.println(count);
        // long t1 = System.nanoTime();

        // long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        // System.out.println(String.format("sort took:%d ms", millis));

        // long t00 = System.nanoTime();
        // long count1 = values.parallelStream().sorted().count();
        // System.out.println(count);
        // long t01 = System.nanoTime();

        // long millis1 = TimeUnit.NANOSECONDS.toMillis(t01 - t00);
        // System.out.println(String.format("parallel sort took:%d ms", millis1));

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
        map.computeIfPresent(3, (num, val) -> val + num);
        map.forEach((id, val) -> System.out.println(val));

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(String.format("%d %d", hoursBetween, minutesBetween));

        //reflection
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);

        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1);

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);

        List<Person> persons = Arrays.asList(
                new Person("steven", "x", 41),
                new Person("ke", "z", 30),
                new Person("johnny", "x", 5),
                new Person("tom", "x", 15)
        );

        Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),
                        (j, p) -> j.add(p.firstName.toUpperCase()),
                        (j1, j2) -> j1.merge(j2),
                        StringJoiner::toString);
        String names = persons.stream().collect(personNameCollector);
        System.out.println(names);

        List<Foo> foos = new ArrayList<>();
        IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
        foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));


    }
}

class FirstLetter {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}

@Hint("hint1")
@Hint("hint2")
class Person {
    String firstName;
    String lastName;
    int age;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}