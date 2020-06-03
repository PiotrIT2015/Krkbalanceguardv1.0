import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.util.LinkedList;
import java.util.Random;

public class MainPanel extends JPanel implements ActionListener{
	static int s = 100;

	static JButton maintab[][] = new JButton[s][s];
	static int tab[][] = new int[s][s];
	static LinkedList<Point> pointslist = new LinkedList<Point>();
	static int count = s*s;
	static double dystab[][] = new double[s][s];
	
	static double A = 86710969050178.5;
	static double B=9.41268203527779;
	static double ro1=0, roznica;
	static double ro2=0;
	static double t=0.001;
	static double granica=4215840000000.0/(s*s);
	
	
	MainPanel(){
		
		JPanel buttpanel= new JPanel();
		this.setLayout(new GridLayout(s,s));
		
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				maintab[i][j]=new JButton();
				maintab[i][j].addActionListener(this);
	    		add(maintab[i][j]);
			}
		}
		
		
		}
	
	static void update(int tab[][], JButton maintab[][]){
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				Random gen = new Random();
				int c1,c2,c3;
				c1=gen.nextInt(255);
				c2=gen.nextInt(255);
				c3=gen.nextInt(255);
				if(tab[i][j]==0) maintab[i][j].setBackground(new Color(255,255,255));
				if(tab[i][j]==1) maintab[i][j].setBackground(Color.gray);
				if(tab[i][j]==2) maintab[i][j].setBackground(Color.pink);
				if(tab[i][j]==3) maintab[i][j].setBackground(Color.green);
				if(tab[i][j]==4) maintab[i][j].setBackground(Color.red);
				if(tab[i][j]==5) maintab[i][j].setBackground(Color.yellow);
				if(tab[i][j]==6) maintab[i][j].setBackground(Color.magenta);
				if(tab[i][j]==7) maintab[i][j].setBackground(Color.orange);
				if(tab[i][j]==8) maintab[i][j].setBackground(Color.darkGray);
				if(tab[i][j]==9) maintab[i][j].setBackground(Color.CYAN);
				if(tab[i][j]==10) maintab[i][j].setBackground(Color.black);
				if(tab[i][j]==11) maintab[i][j].setBackground(new Color(100,100,100));
				if(tab[i][j]==12) maintab[i][j].setBackground(new Color(150,100,100));
				if(tab[i][j]==13) maintab[i][j].setBackground(new Color(100,150,100));
				if(tab[i][j]==14) maintab[i][j].setBackground(new Color(100,100,150));
				if(tab[i][j]==15) maintab[i][j].setBackground(new Color(200,100,100));
				if(tab[i][j]==16) maintab[i][j].setBackground(new Color(100,100,200));
				if(tab[i][j]==17) maintab[i][j].setBackground(new Color(100,200,100));
				if(tab[i][j]==18) maintab[i][j].setBackground(new Color(100,100,100));
				if(tab[i][j]==19) maintab[i][j].setBackground(new Color(150,100,100));
				if(tab[i][j]==20) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==21) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==22) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==23) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==24) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==25) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==26) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==27) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==28) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==29) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==30) maintab[i][j].setBackground(new Color(c1,c2,c3));
				if(tab[i][j]==17) maintab[i][j].setBackground(new Color(100,200,100));
				
			}
		}
	}
	
	static void losuj(int[][] tabx){
		
		Random genx = new Random();
		Random geny = new Random();
		Random gencolor = new Random();
		int x,y,color, test=0;
		
		while (test < 5){
		x=genx.nextInt(s);
		y=geny.nextInt(s);
		
			color=gencolor.nextInt(6)+1;
			tabx[x][y]=color;
			test++;
		}
	}
	
	static void losujreg(int [][]tabx){
		int reg=20;
		Random gencolor = new Random();
		for(int i=reg; i<s; i=i+reg){
			for(int j=reg; j<s; j=j+reg){
			tabx[i][j]=gencolor.nextInt(6)+1;
			}
		}
	}

	public static void point (){
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
					Point a = new Point(i,j);
					pointslist.add(a);
			}
		}
	
	}
	
	static public void monteCarlo(int tabx[][]){
		int listnumber;
		int xl, yl;
		count = s*s;
		
		Point a = new Point(0,0);
		Random gen = new Random();
		int temptab[][]=new int[s][s];
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				temptab[i][j]=tabx[i][j];
			}
		}
		
		while (count>0){
		listnumber=gen.nextInt(pointslist.size());
		xl= pointslist.get(listnumber).x;
		yl= pointslist.get(listnumber).y;
		pointslist.remove(listnumber);
		System.out.print(xl+" "+yl+" - ");
		int check[]=new int[7];
		
		if(xl>0 && xl<s-1 && yl>0 && yl<s-1){
			check[temptab[xl-1][yl-1]]++; 
			check[temptab[xl-1][yl]]++;
			check[temptab[xl-1][yl+1]]++;
			check[temptab[xl][yl-1]]++;
			check[temptab[xl][yl+1]]++;
			check[temptab[xl+1][yl-1]]++;
			check[temptab[xl+1][yl]]++;
			check[temptab[xl+1][yl+1]]++;
			}
		for(int i=0 ;i<7 ; i++){
			System.out.println("tab"+i+"="+check[i]);
		}
		int biggest = 0;
		for(int i=0;i<7;i++) check[i]=0;
		for(int i=0;i<5;i++){ 
			if(check[i+1]>check[i] ){
				biggest=i+1;
			}
		}/*
		for(int i=0; i<colorsnumber; i++){
			if(i!=biggest && check[i]==check[biggest]){
				int o = gen2.nextInt(2);
					if (o==1) biggest = check[i];
					else biggest = check[biggest];
			}
				
		}*/
			
		tabx[xl][yl]=biggest;
		count=count-2;
		}
	}	
	
	
	static void mc(int tabx[][]){
		point();
		int temp[][] = new int[s][s];
		Random gen = new Random();
		Random gen2 = new Random();
		int x2,y2,rand, biggest;
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				temp[i][j]=tabx[i][j];
			}
		}
		int checktab[]=new int[7];

		int counter = s*s;
		while(counter>0){

			for (int j=0 ;j<7;j++) {checktab[j]=0;}
			rand=gen.nextInt(pointslist.size());
			x2= pointslist.get(rand).x;
			y2= pointslist.get(rand).y;
			pointslist.remove(rand);
			if(x2>0 && y2>0 && x2<s-1 && y2 <s-1){	
				for(int i=1 ;i<7; i++){
					if(temp[x2-1][y2-1]==i) checktab[i]++; 
					if(temp[x2-1][y2]==i) checktab[i]++;
					if(temp[x2-1][y2+1]==i) checktab[i]++; 
					if(temp[x2][y2-1]==i) checktab[i]++;
					if(temp[x2][y2+1]==i) checktab[i]++; 
					if(temp[x2+1][y2-1]==i) checktab[i]++;
					if(temp[x2+1][y2]==i) checktab[i]++;
					if(temp[x2+1][y2+1]==i) checktab[i]++;
					
					}
				}
				biggest = 0;
				for(int i=0; i<7; i++){
					if(checktab[i]>biggest) biggest = i;
				}
				System.out.println(checktab[0]+""+checktab[1]+""+checktab[2]+""+checktab[3]+""+checktab[4]+""+checktab[5]+""+checktab[6]+" "+biggest);
				
				tabx[x2][y2]=biggest;
				/*int p;
			if(checktab[biggest]==4){
				for(int i=0; i<7; i++){
					if(i!=biggest) {
						if(checktab[i]==checktab[biggest]){
							p=gen2.nextInt(2);
							if(p==1)tabx[x2][y2]=biggest;
							else tabx[x2][y2]=i;
						}
					}
				}
			}else{
				tabx[x2][y2]=biggest;
			}*/
	

			counter--;
		}
	}
	
	
	static void rec(int tabx[][]){
		
	}
	
	
	
	static void mc2(int tabx[][]){
		point();
		int temp[][] = new int[s][s];
		Random gen = new Random();
		int x2,y2,rand, biggest;
		
		int checktab[]=new int[7];
		
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				temp[i][j]=tabx[i][j];
			}
		}
		
		int counter = s*s;
		while(counter>0){
			
			for (int j=0 ;j<7;j++) {checktab[j]=0;}
			rand=gen.nextInt(pointslist.size());
			x2= pointslist.get(rand).x;
			y2= pointslist.get(rand).y;
			pointslist.remove(rand);
			if(x2>0 && y2>0 && x2<s-1 && y2 <s-1){	
				int n = tabx[x2][y2];
				int il=0;
				if(temp[x2-1][y2-1]==n) il++; 
				if(temp[x2-1][y2]==n) il++; 
				if(temp[x2-1][y2+1]==n) il++; 
				if(temp[x2][y2-1]==n) il++; 
				if(temp[x2][y2+1]==n) il++; 
				if(temp[x2+1][y2-1]==n) il++; 
				if(temp[x2+1][y2]==n) il++; 
				if(temp[x2+1][y2+1]==n) il++; 
				
				if(il<4){
					int a=0;
					if(temp[x2-1][y2-1]!=n) a++; 
					if(temp[x2-1][y2]!=n) a++; 
					if(temp[x2-1][y2+1]!=n) a++; 
					if(temp[x2][y2-1]!=n) a++; 
					if(temp[x2][y2+1]!=n) a++; 
					if(temp[x2+1][y2-1]!=n) a++; 
					if(temp[x2+1][y2]!=n) a++; 
					if(temp[x2+1][y2+1]!=n) a++; 
					
				}
				
			
				
				
				
				
				
				
				
				
				}
				biggest = 0;
				for(int i=0; i<7; i++){
					if(checktab[i]>biggest) biggest = i;
				}
				
				/*int ch=0;
				int biggest2;
				int first=0,second=0;
				for(int i=0; i<7; i++){
					if(checktab[i]==biggest) {
						++ch;
						if(ch==1) first=i;
						if(ch==2) {
							second=i;
							biggest2=gen.nextInt(2);
							if(biggest2 == 0) biggest=first;
							else biggest = second;
						}
					}
				}*/
			//System.out.println(checktab[0]+""+checktab[1]+""+checktab[2]+""+checktab[3]+""+checktab[4]+""+checktab[5]+""+
			//	checktab[6]+" "+biggest);
			tabx[x2][y2]=biggest;
			
			counter--;
		}
		update(tabx, maintab);
	}
	
	
	
	
	
	
	
	static void square_inclusion(int tabx[][]){

            point();
		int temp[][] = new int[s][s];
		Random gen = new Random();
		int x2,y2,rand, biggest;
		
		int checktab[]=new int[7];
		
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				temp[i][j]=tabx[i][j];
			}
		}
		
		int counter = s*s;
                
                while(counter>0){
			
			for (int j=0 ;j<7;j++) {checktab[j]=0;}
			rand=gen.nextInt(pointslist.size());
			x2= pointslist.get(rand).x;
			y2= pointslist.get(rand).y;
			pointslist.remove(rand);
			if(x2>0 && y2>0 && x2<s-1 && y2 <s-1){	
				int n = tabx[x2][y2];
				int il=0;
				if(temp[x2-1][y2-1]==n) il++; 
				if(temp[x2-1][y2]==n) il++; 
				if(temp[x2-1][y2+1]==n) il++; 
				if(temp[x2][y2-1]==n) il++; 
				if(temp[x2][y2+1]==n) il++; 
				if(temp[x2+1][y2-1]==n) il++; 
				if(temp[x2+1][y2]==n) il++; 
				if(temp[x2+1][y2+1]==n) il++; 
				
				if(il<4){
					int a=0;
					if(temp[x2-1][y2-1]!=n) a++; 
					if(temp[x2-1][y2]!=n) a++; 
					if(temp[x2-1][y2+1]!=n) a++; 
					if(temp[x2][y2-1]!=n) a++; 
					if(temp[x2][y2+1]!=n) a++; 
					if(temp[x2+1][y2-1]!=n) a++; 
					if(temp[x2+1][y2]!=n) a++; 
					if(temp[x2+1][y2+1]!=n) a++; 
					
				}
                                
                                }
				biggest = 0;
				for(int i=0; i<7; i++){
					if(checktab[i]>biggest) biggest = i;
				}
				
				int ch=0;
				int biggest2;
				int first=0,second=0;
				for(int i=0; i<7; i++){
					if(checktab[i]==biggest) {
						++ch;
						if(ch==1) first=i;
						if(ch==2) {
							second=i;
							biggest2=gen.nextInt(2);
							if(biggest2 == 0) biggest=first;
							else biggest = second;
						}
					}
				}
			//System.out.println(checktab[0]+""+checktab[1]+""+checktab[2]+""+checktab[3]+""+checktab[4]+""+checktab[5]+""+
			//	checktab[6]+" "+biggest);
			tabx[x2][y2]=biggest;
			
			counter--;
		}
		update(tabx, maintab);
            
        }
	
	static void circular_inclusion(int tabx[][]){
		point();
		int temp[][] = new int[s][s];
		Random gen = new Random();
		Random gen2 = new Random();
		int x2,y2,rand, biggest;
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				temp[i][j]=tabx[i][j];
			}
		}
		int checktab[]=new int[7];

		int counter = s*s;
		while(counter>0){

			for (int j=0 ;j<7;j++) {checktab[j]=0;}
			rand=gen.nextInt(pointslist.size());
			x2= pointslist.get(rand).x;
			y2= pointslist.get(rand).y;
			pointslist.remove(rand);
			if(x2>0 && y2>0 && x2<s-1 && y2 <s-1){	
				for(int i=1 ;i<7; i++){
					if(temp[x2-1][y2-1]==i) checktab[i]++; 
					if(temp[x2-1][y2]==i) checktab[i]++;
					if(temp[x2-1][y2+1]==i) checktab[i]++; 
					if(temp[x2][y2-1]==i) checktab[i]++;
					if(temp[x2][y2+1]==i) checktab[i]++; 
					if(temp[x2+1][y2-1]==i) checktab[i]++;
					if(temp[x2+1][y2]==i) checktab[i]++;
					if(temp[x2+1][y2+1]==i) checktab[i]++;
					
					}
				}
				biggest = 0;
				for(int i=0; i<7; i++){
					if(checktab[i]>biggest) biggest = i;
				}
				System.out.println(checktab[0]+""+checktab[1]+""+checktab[2]+""+checktab[3]+""+checktab[4]+""+checktab[5]+""+checktab[6]+" "+biggest);
				
				tabx[x2][y2]=biggest;
				int p;
			if(checktab[biggest]==4){
				for(int i=0; i<7; i++){
					if(i!=biggest) {
						if(checktab[i]==checktab[biggest]){
							p=gen2.nextInt(2);
							if(p==1)tabx[x2][y2]=biggest;
							else tabx[x2][y2]=i;
						}
					}
				}
			}else{
				tabx[x2][y2]=biggest;
			}
	

			counter--;
		}
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	static void rek(int tabx[][]){
		ro1=(A/B+(1-A/B)*Math.exp(-B*t));
		boolean tabb[][] = new boolean[s][s];
		Random gen = new Random();
		System.out.println(ro2);
		int tab[][]=new int[s][s];
		
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=1; i<s-1; i++){
			for(int j=1; j<s-1; j++){
				if(tab[i-1][j-1]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i-1][j]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i-1][j+1]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i][j-1]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i][j+1]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i+1][j-1]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i+1][j]!=tab[i][j]) tabb[i][j]=false; 
				else if(tab[i+1][j+1]!=tab[i][j]) tabb[i][j]=false; 
				
				else tabb[i][j]=true;
			}
		}
		
		
		int rr = gen.nextInt(5)+12; // to sa procenty - dzielone pozniej przez 10
		int bb = gen.nextInt(4)+3;

		for(int i=1; i<s-1; i=i+2){
			for(int j=1; j<s-1; j=j+2){
				//System.out.println(dystab[1][1]);
				if(tabb[i][j]==false) 
				{
				dystab[i][j]+=((double)rr/10)*((ro1-ro2)/s*s);
			//	System.out.println("w1 ");
				}
				else 
				{
			//		System.out.println("w2 ");
					
					dystab[i][j]+=((double)bb/10)*((ro1-ro2)/(s*s));
				}
				if(dystab[i][j]>=granica) {
					
				//	System.out.println(granica);
					int col = gen.nextInt(10);
					
					
					tabx[i][j]=col;
					
					
			    roznica=dystab[i][j]-granica;
				if (i>0&&i<s-1&&j>0&&j<s-1){
					dystab[i-1][j]+=roznica/8;
					dystab[i+1][j]+=roznica/8;
					dystab[i-1][j-1]+=roznica/8;
		            dystab[i][j-1]+=roznica/8;
		            dystab[i+1][j-1]+=roznica/8;
		            dystab[i-1][j+1]+=roznica/8;
		            dystab[i][j+1]+=roznica/8;
		            dystab[i+1][j+1]+=roznica/8;
				}
				//-------------
				}
				
			}
		}
		
		ro2=ro1;
		t+=0.001;
		
		for(int i=1; i<s-1; i++){
			for(int j=1; j<s-1; j++){
				if(tabx[i][j]==tab[i][j]) tabx[i][j]=0;
			}
		}	
		update(tabx,maintab);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
	
				Random gen = new Random();
				int color;
				color=gen.nextInt(6)+1;
				for(int i=0; i<s; i++){
					for(int j=0; j<s; j++){
						if(maintab[i][j]==a.getSource()){
							tab[i][j]=color;
							update(tab, maintab);
						}
					}
				}
	}
	
}
