import java.util.Random;

public class RandomCode {
    private static final String CODE = "0123456789";

    public static String generateCode(Integer length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(CODE.charAt(random.nextInt(CODE.length())));
        }

        return sb.toString();
    }
}