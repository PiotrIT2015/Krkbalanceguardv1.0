import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Main extends JFrame{
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				
				for(int i=0; i<MainPanel.s; i++){
					for(int j=0;j <MainPanel.s; j++){
						MainPanel.dystab[i][j]=1;
					}
				}
				
			Frame window = new Frame();	
		
				
			}
			});
	}
}
