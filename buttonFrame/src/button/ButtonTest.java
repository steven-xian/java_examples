package button;

import java.awt.*;
import javax.swing.*;

public class ButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new button.ButtonFrame();

            frame.setTitle("Button Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
