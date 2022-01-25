import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonteCarlo extends JButton implements ActionListener {
    MainPanel mainPanel;

    MonteCarlo(MainPanel mainPanel) {
        super("MonteCarlo");
        this.mainPanel = mainPanel;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 5; i++) {

            mainPanel.mc_p(mainPanel.tab);
            //mainPanel.mc(mainPanel.tab);
            mainPanel.update(mainPanel.tab, mainPanel.maintab);
        }
    }
}
