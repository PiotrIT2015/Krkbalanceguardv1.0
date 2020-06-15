
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
//import javafx.scene.control.Spinner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class Menu2 extends JPanel implements ActionListener{
    
	Menu2(){
		JPanel menubutt = new JPanel();
		setSize(200,200);
                Label name1 = new Label("Typ i ilość inkluzji:");
                //add(name1);
                JTextField inclusion = new JTextField();
                inclusion.setBounds(2, 2, 10, 10);
		//add(inclusion);
		JButton square = new JButton("square");
		add(square);
		JButton circular = new JButton("circular");
		add(circular);
                Label name2 = new Label("Ilosc ziaren:");
                //add(name2);
                JTextField neighbourhood = new JTextField();
                neighbourhood.setBounds(2, 2, 10, 10);          
		//add(neighbourhood);
		
                Label name3 = new Label("Typ dystrybucji");
                //add(name3);
                JTextField tf = new JTextField();
                tf.setBounds(2, 2, 10, 10);
                //add(tf);
		JButton homogenous = new JButton("homogenous");
		add(homogenous);
		JButton heterogenous = new JButton("heterogenous");
		add(heterogenous);
		JButton energy = new JButton("Energy");
		add(energy);
		JButton losuj = new JButton("losuj");
		add(losuj);
                
                JSpinner spinner = new JSpinner();
             
                
                JLabel lblZiarna = new JLabel("Ziarna");
		//add(lblZiarna);
		
		spinner.setModel(new SpinnerNumberModel(20, 3, 100, 1));
		add(spinner);
                
                JTextField kroki = new JTextField(10);
                add(kroki);
		
		JButton btnDodajZiarna = new JButton("Enter");
		btnDodajZiarna.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                            
                            for(int i=0 ;i<(Integer) spinner.getValue(); i++){
                                if(kroki.getText().equals("CIRCULAR")){
				MainPanel.circular(MainPanel.tab); 
                                MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                }
                                if(kroki.getText().equals("SQUARE")){
                                 MainPanel.square(MainPanel.tab); 
                                 MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                        }
                                if(kroki.getText().equals("HOMOGENOUS")){
                                    //for(int a = 0 ; a<5 ; a++){
                                   MainPanel.energy_homo2(MainPanel.tab);
                                 MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                   // }
                                        }
                                if(kroki.getText().equals("HETEROGENOUS")){
                                 MainPanel.energy_hetero(MainPanel.tab); 
                                 MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                        }
                                if(kroki.getText().equals("ENERGY")){
                                  // for(int a=0 ; a<10; a++){
                                 MainPanel.energy_homo(MainPanel.tab); 
                                 MainPanel.energy(MainPanel.tab); 
                                 MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                //}
                                        }
                            }
                        }
		});
		add(btnDodajZiarna);
	   
                
		this.setLayout(new GridLayout(10,0));
		
		
		
		
		

		
		
		
	/*	circular.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
			
				for(int i=0; i<5; i++){
                                MainPanel.circular(MainPanel.tab);
				MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                }
		     }
                
		});*/
                
                
               circular.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                            
                            kroki.setText("CIRCULAR");
                        }
		});
		add(btnDodajZiarna); 
                
		
	/*	square.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
			
				for(int i=0; i<5; i++){
                                MainPanel.square(MainPanel.tab);
				MainPanel.update(MainPanel.tab, MainPanel.maintab);
                                }
		     }
		}); */
                
                square.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                            
                            kroki.setText("SQUARE");
                        }
		});
		add(btnDodajZiarna);
		
		
		
		
		
		/*homogenous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.homogenous_distribution(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});*/
		
                 energy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

					//MainPanel.rek(MainPanel.tab); //old
			 kroki.setText("ENERGY");		
                                       // MainPanel.rec(MainPanel.tab); //my NEW
					//for(int i=0 ; i<50; i++) Rozrost.vonNeumann(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				
			}
		});
		
	/*	heterogenous.addActionListener(new ActionListener() {
			
        
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.heterogenous_distribution(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});*/
                
                 homogenous.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                            
                            kroki.setText("HOMOGENOUS");
                        }
		});
		add(btnDodajZiarna);
                
                 heterogenous.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                            
                            kroki.setText("HETEROGENOUS");
                        }
		});
		add(btnDodajZiarna);
		
		
		
		losuj.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
				for(int i=0; i<5; i++)MainPanel.losuj(MainPanel.tab);
				MainPanel.update(MainPanel.tab, MainPanel.maintab);
			
		}
	});
		
		
		
	

		
}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}