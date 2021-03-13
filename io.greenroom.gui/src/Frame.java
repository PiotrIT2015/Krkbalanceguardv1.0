import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    MainPanel mainPanel = new MainPanel();

    Frame() {
        super("Rozrost ziaren");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 800));
        pack();
        setVisible(true);

        mainPanel.setBounds(100, 100, 500, 500);
        setVisible(true);

        add(mainPanel);
        pack();

        Menu mainPanel2 = new Menu(mainPanel);
        add(mainPanel2, BorderLayout.LINE_START);

        Menu2 mainPanel3 = new Menu2(mainPanel);
        add(mainPanel3, BorderLayout.LINE_END);
    }

    void init() {
        for (int i = 0; i < mainPanel.s; i++) {
            for (int j = 0; j < mainPanel.s; j++) {
                mainPanel.dystab[i][j] = 1;
            }
        }
    }

}
