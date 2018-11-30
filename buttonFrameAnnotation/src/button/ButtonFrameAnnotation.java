package button;

import javax.swing.*;
import javax.xml.ws.Action;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrameAnnotation extends JFrame {
    private JPanel buttonPanel;
    private JButton yellowButton = null;
    private JButton blueButton = null;
    private JButton redButton = null;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrameAnnotation() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        yellowButton = new JButton("Yellow");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        buttonPanel = new JPanel();

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);

        ActionListenerInstaller.processAnnotations(this);
    }

    @ActionListenerFor(source = "yellowButton")
    public void yellowBackground() {
        buttonPanel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source = "blueButton")
    public void blueBackground() {
        buttonPanel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source = "redButton")
    public void redBackground() {
        buttonPanel.setBackground(Color.RED);
    }
}
