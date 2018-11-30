
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class AnonymousClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);
        clock.start2(2000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock {
    public void start(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };

        Timer t = new Timer(interval, listener);
        t.start();
    }

    public void start2(int interval, boolean beep) {
        Timer t = new Timer(interval, e -> {
            System.out.println("The time is " + new Date());
            if (beep) System.out.println("start2");
        });
        t.start();
    }
}
