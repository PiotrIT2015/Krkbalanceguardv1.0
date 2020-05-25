import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Spinner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu2 extends JPanel implements ActionListener{
	Menu2(){
		JPanel menubutt = new JPanel();
		setSize(200,200);
                Label name1 = new Label("Typ i ilość inkluzji:");
                add(name1);
                JTextField inclusion = new JTextField();
                inclusion.setBounds(2, 2, 10, 10);
		add(inclusion);
		JButton square = new JButton("square");
		add(square);
		JButton circular = new JButton("circular");
		add(circular);
                Label name2 = new Label("Ilosc ziaren:");
                add(name2);
                JTextField ziarna = new JTextField();
                ziarna.setBounds(2, 2, 10, 10);          
		add(ziarna);
		JButton enter = new JButton("Enter");
		add(enter);
		JButton reset = new JButton("Reset");
		add(reset);
                Label name3 = new Label("Typ dystrybucji");
                add(name3);
                JTextField tf = new JTextField();
                tf.setBounds(2, 2, 10, 10);
                add(tf);
		JButton homogenous = new JButton("homogenous");
		add(homogenous);
		JButton heterogenous = new JButton("heterogenous");
		add(heterogenous);
		
		
		
	     
            
		
                
		this.setLayout(new GridLayout(10,0));
		
		
		
		
		

		
		
		
		circular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.circular_inclusion(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		square.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					//Rozrost.sqare_inclusion(MainPanel.tab);
                                        MainPanel.square_inclusion(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		
		
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.grains_amount(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.grains_amount(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		homogenous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.homogenous_distribution(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		heterogenous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.heterogenous_distribution(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		
		
		
		
		
	

		
}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}