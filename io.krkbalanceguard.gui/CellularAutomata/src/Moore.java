import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moore extends JButton implements ActionListener {
    Rozrost rozrost;
    MainPanel mainPanel;

    Moore(MainPanel mainPanel, Rozrost rozrost) {
        super("moore");
        this.rozrost = rozrost;
        this.mainPanel = mainPanel;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 5; i++) {
            rozrost.periodmoore(mainPanel.tab);
            mainPanel.update(mainPanel.tab, mainPanel.maintab);
        }
    }
}
