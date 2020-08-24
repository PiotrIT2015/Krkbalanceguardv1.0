
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends JPanel implements ActionListener{
	Menu(){
		JPanel menubutt = new JPanel();
		setSize(200,200);
		JButton moore = new JButton("moore");
		add(moore);
		JButton vonNeumann = new JButton("vonNeumann");
		add(vonNeumann);
		JButton pentleft = new JButton("pentleft");
		//add(pentleft);
		JButton pentright = new JButton("pentright");
		//add(pentright);
		JButton pentup = new JButton("pentup");
		//add(pentup);
		JButton pentdown = new JButton("pentdown");
		//add(pentdown);
		JButton hexright = new JButton("hexright");
		//add(hexright);
		JButton hexleft = new JButton("hexleft");
		//add(hexleft);
		JButton rek = new JButton("rekrystalizacja");
		add(rek);
		JButton mc = new JButton("MonteCarlo");
		add(mc);
		
		JButton losujreg = new JButton("losuj reg");
		add(losujreg);
		JButton period = new JButton("periodyczny");
		add(period);
                JButton energy = new JButton("Energia");
		add(period);
                JButton penta = new JButton("Pentagonalne");
		add(penta);
		JButton heksa = new JButton("Heksagonalne");
		add(heksa);
	       JButton dualphase = new JButton("Dualphase");
		add(dualphase);
		
		
		this.setLayout(new GridLayout(10,0));
		
		
		
		
		

		
		penta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
                                    
                                     Random r = new Random();
                                    int p = r.nextInt(5)+1;                            
                                    
                                    switch(p){
                                        case 1:
                                                Rozrost.pentright(MainPanel.tab);
                                        case 2:
                                                Rozrost.pentleft(MainPanel.tab);
                                        case 3:
                                                Rozrost.pentup(MainPanel.tab);
                                        case 4:
                                                Rozrost.pentdown(MainPanel.tab);
                                                      
                                    }
					//Rozrost.grains_amount(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab); 
				}
			}
		});
		
		heksa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
                                    
                                    Random r = new Random();
                                    int p = r.nextInt(5)+1;                            
                                    
                                    switch(p){
                                        case 1:
                                                Rozrost.hexleft(MainPanel.tab);
                                        case 2:
                                                Rozrost.hexright(MainPanel.tab);
                                        default:
                                                MainPanel.update(MainPanel.tab, MainPanel.maintab);       
                                    }
                               
                                        //Rozrost.grains_amount(MainPanel.tab);
				}
			}
		});
		
		
		
		moore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.periodmoore(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		vonNeumann.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.vonNeumann(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		
		
		pentleft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.pentleft(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		pentright.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.pentright(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		pentup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.pentup(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		pentdown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.pentdown(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		hexright.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.hexright(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		
		hexleft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.hexleft(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				}
			}
		});
		
		rek.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

					MainPanel.rek(MainPanel.tab);
					
                                        //MainPanel.rec(MainPanel.tab); //my NEW
			//		for(int i=0 ; i<50; i++) Rozrost.vonNeumann(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
				
			}
		});
                
               
		
		
	mc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
                            for(int i=0 ;i<5; i++){
                                
                                MainPanel.mc_p(MainPanel.tab);
					//MainPanel.mc(MainPanel.tab);
					MainPanel.update(MainPanel.tab, MainPanel.maintab);
                            }
		
			}
		});
		
		
		
	
		
	losujreg.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		
				MainPanel.losujreg(MainPanel.tab);
				MainPanel.update(MainPanel.tab, MainPanel.maintab);
			
		}
	});
        
        
        dualphase.addActionListener(new ActionListener() {
            
           
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		
                    MainPanel.dualphase(MainPanel.tab);
				Rozrost.growth_reg(MainPanel.tab);
				MainPanel.update(MainPanel.tab, MainPanel.maintab);
        
		}
	});
        
        
period.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		Rozrost.period=true;
		 ((JButton)e.getSource()).setBackground(Color.green);  
		}
	});
		
}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}