
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import javafx.scene.control.Spinner;


public class Menu2 extends JPanel implements ActionListener {
    MainPanel mainPanel;

    Menu2(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        JPanel menubutt = new JPanel();
        setSize(200, 200);
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

                for (int i = 0; i < (Integer) spinner.getValue(); i++) {
                    if (kroki.getText().equals("CIRCULAR")) {
                        mainPanel.circular(mainPanel.tab);
                        mainPanel.update(mainPanel.tab, mainPanel.maintab);
                    }
                    if (kroki.getText().equals("SQUARE")) {
                        mainPanel.square(mainPanel.tab);
                        mainPanel.update(mainPanel.tab, mainPanel.maintab);
                    }
                    if (kroki.getText().equals("HOMOGENOUS")) {
                        //for(int a = 0 ; a<5 ; a++){
                        mainPanel.energy_homo2(mainPanel.tab);
                        mainPanel.update(mainPanel.tab, mainPanel.maintab);
                        // }
                    }
                    if (kroki.getText().equals("HETEROGENOUS")) {
                        mainPanel.energy_hetero(mainPanel.tab);
                        mainPanel.update(mainPanel.tab, mainPanel.maintab);
                    }
                    if (kroki.getText().equals("ENERGY")) {
                        // for(int a=0 ; a<10; a++){
                        mainPanel.energy_homo(mainPanel.tab);
                        mainPanel.energy(mainPanel.tab);
                        mainPanel.update(mainPanel.tab, mainPanel.maintab);
                        //}
                    }
                }
            }
        });
        add(btnDodajZiarna);


        this.setLayout(new GridLayout(10, 0));
		
		
		
		
		

		
		
		
	/*	circular.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
			
				for(int i=0; i<5; i++){
                                mainPanel.circular(mainPanel.tab);
				mainPanel.update(mainPanel.tab, mainPanel.maintab);
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
                                mainPanel.square(mainPanel.tab);
				mainPanel.update(mainPanel.tab, mainPanel.maintab);
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
					Rozrost.homogenous_distribution(mainPanel.tab);
					mainPanel.update(mainPanel.tab, mainPanel.maintab);
				}
			}
		});*/

        energy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //mainPanel.rek(mainPanel.tab); //old
                kroki.setText("ENERGY");
                // mainPanel.rec(mainPanel.tab); //my NEW
                //for(int i=0 ; i<50; i++) Rozrost.vonNeumann(mainPanel.tab);
                mainPanel.update(mainPanel.tab, mainPanel.maintab);

            }
        });
		
	/*	heterogenous.addActionListener(new ActionListener() {
			
        
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0 ;i<5; i++){
					Rozrost.heterogenous_distribution(mainPanel.tab);
					mainPanel.update(mainPanel.tab, mainPanel.maintab);
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

                for (int i = 0; i < 5; i++) mainPanel.losuj(mainPanel.tab);
                mainPanel.update(mainPanel.tab, mainPanel.maintab);

            }
        });


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }

}