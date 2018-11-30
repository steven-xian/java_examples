import java.util.*;

public class enum_test {
    public static void main(String[] args) {
        System.out.println("enum_test");

        Scanner in = new Scanner(System.in);
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size: " + size);
        System.out.println("abbr: " + size.getAbbr());
        if (size == Size.SMALL) {
            System.out.println("size is small");
        }
    }
}

enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXLARGE("XL");

    private String abbr;

    private Size(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return this.abbr;
    }
}