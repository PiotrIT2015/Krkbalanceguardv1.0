import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame window = new Frame();
                window.init();
            }
        });
    }
}
