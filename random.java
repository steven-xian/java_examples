import java.util.Random;

public class random {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.format("%s%n", RandomCode.generateCode(6));
        }
    }
}