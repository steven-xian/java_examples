package button;

import javax.swing.*;
import java.awt.*;

public class ButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ButtonFrameAnnotation();

            frame.setTitle("Button Annotation Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
