package set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.logging.*;

public class SetTest {
    public static void main(String[] args) {
//        LoggerFactory.getLogger("com.horstmann").setLevel(Level.FINEST);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);
        LoggerFactory.getLogger("com.horstmann").addHandler(handler);
        Set<Item> parts = new HashSet<>();
        parts.add(new Item("Toaster", 1279));
        parts.add(new Item("Microwave", 4104));
        parts.add(new Item("Toaster", 1279));
        System.out.println(parts);
    }
}