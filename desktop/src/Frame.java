import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Frame extends JFrame{
	
	Frame(){
		super("Rozrost ziaren");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000, 800));
		pack();
		setVisible(true);
		
		MainPanel tit = new MainPanel();
		tit.setBounds(100,100,500,500);
		setVisible(true);
		
		add(tit);
		pack();
		
		Menu tit2 = new Menu();
		add(tit2,BorderLayout.LINE_START);
                
                Menu2 tit3 = new Menu2();
		add(tit3,BorderLayout.LINE_END);
		}
	
	

}
