
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Menu extends JPanel /*implements ActionListener*/ {
    Rozrost rozrost;
    MainPanel mainPanel;

    Menu(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.rozrost = new Rozrost(mainPanel);
        JPanel menubutt = new JPanel();
        setSize(200, 200);
//        JButton moore = new JButton("moore");
        add(new Moore(mainPanel, rozrost));
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
//        JButton mc = new JButton("MonteCarlo");
        add(new MonteCarlo(mainPanel));

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


        this.setLayout(new GridLayout(10, 0));


        penta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {

                    Random r = new Random();
                    int p = r.nextInt(5) + 1;

                    switch (p) {
                        case 1:
                            rozrost.pentright(mainPanel.tab);
                        case 2:
                            rozrost.pentleft(mainPanel.tab);
                        case 3:
                            rozrost.pentup(mainPanel.tab);
                        case 4:
                            rozrost.pentdown(mainPanel.tab);

                    }
                    //rozrost.grains_amount(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });

        heksa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {

                    Random r = new Random();
                    int p = r.nextInt(5) + 1;

                    switch (p) {
                        case 1:
                            rozrost.hexleft(mainPanel.tab);
                        case 2:
                            rozrost.hexright(mainPanel.tab);
                        default:
                            mainPanel.update(mainPanel.tab, mainPanel.maintab);
                    }

                    //rozrost.grains_amount(mainPanel.tab);
                }
            }
        });


//        moore.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                for (int i = 0; i < 5; i++) {
//                    rozrost.periodmoore(mainPanel.tab);
//                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
//                }
//            }
//        });

        vonNeumann.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.vonNeumann(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });


        pentleft.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.pentleft(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });

        pentright.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.pentright(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });


        pentup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.pentup(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });


        pentdown.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.pentdown(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });

        hexright.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.hexright(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });


        hexleft.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    rozrost.hexleft(mainPanel.tab);
                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
                }
            }
        });

        rek.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                mainPanel.rek(mainPanel.tab);

                //mainPanel.rec(mainPanel.tab); //my NEW
                //		for(int i=0 ; i<50; i++) rozrost.vonNeumann(mainPanel.tab);
                mainPanel.update(mainPanel.tab, mainPanel.maintab);

            }
        });


//        mc.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                for (int i = 0; i < 5; i++) {
//
//                    mainPanel.mc_p(mainPanel.tab);
//                    //mainPanel.mc(mainPanel.tab);
//                    mainPanel.update(mainPanel.tab, mainPanel.maintab);
//                }
//
//            }
//        });


        losujreg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                mainPanel.losujreg(mainPanel.tab);
                mainPanel.update(mainPanel.tab, mainPanel.maintab);

            }
        });


        dualphase.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {


                mainPanel.dualphase(mainPanel.tab);
                rozrost.growth_reg(mainPanel.tab);
                mainPanel.update(mainPanel.tab, mainPanel.maintab);

            }
        });


        period.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                rozrost.period = true;
                ((JButton) e.getSource()).setBackground(Color.green);
            }
        });

    }


//    @Override
//    public void actionPerformed(ActionEvent arg0) {
//         //TODO Auto-generated method stub
//
//    }

}