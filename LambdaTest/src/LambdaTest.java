import java.util.Arrays;
import java.util.Date;
import javax.swing.*;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{
                "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
        };

        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by compareToString:");
        Arrays.sort(planets, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();

        Timer t2 = new Timer(1000, System.out::println);
        t2.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
