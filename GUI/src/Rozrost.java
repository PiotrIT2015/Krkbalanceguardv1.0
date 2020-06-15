

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Rozrost {
	static boolean period = false;
	
	static void moore(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		
		for(int i=1; i<MainPanel.s-1; i++){
			for(int j=1 ;j<MainPanel.s-1; j++){
				if(tab[i][j]!=0){
					if(tab[i][j]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i-1][j+1]=tab[i][j];
					
					if(tab[i-1][j]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					
					if(tab[i][j+1]==0)tabx[i][j-1]=tab[i][j];
					//if(tab[i][j-1]==0)tabx[i][j+1]=tab[i][j];
				}
			}
		}
	}
	
	static void growth_reg(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		int reg=20;
		Random gencolor = new Random();
		for(int i=reg; i<MainPanel.s; i=i+reg){
			for(int j=reg; j<MainPanel.s; j=j+reg){
			tab[i][j]=gencolor.nextInt(6)+1;
			}
		}
		
		
		for(int i=1; i<MainPanel.s-1; i=i+reg){
			for(int j=1 ;j<MainPanel.s-1; j=j+reg){
				if(tab[i][j]!=0){
					if(tab[i][j]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i-1][j+1]=tab[i][j];
					
					if(tab[i-1][j]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					
					if(tab[i][j+1]==0)tabx[i][j-1]=tab[i][j];
					//if(tab[i][j-1]==0)tabx[i][j+1]=tab[i][j];
				}
			}
		}
	}
	
        
        
	static void vonNeumann(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
				
				
				
				
			}
		}
	}
	
	
	static void pentleft(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
			}
		}
	}
	
	
	static void pentright(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
			}
		}
	}
	
	
	static void pentup(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
			}
		}
	}
	
	
	static void pentdown(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
			}
		}
	}	
	
	
	
	static void hexright(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
			}
		}
	}
	
	
	static void hexleft(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		for(int i=1; i<MainPanel.s-1; i++){
			for(int j=1 ;j<MainPanel.s-1; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
			}
		}
	}
	
	
	
	
	static void periodmoore(int tabx[][]){
		int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];
			}
		}
		
		
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
				
			}
		}
	}
	

        
	
        
        static void homogenous_distribution(int tabx[][]){
            
            
            	int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];    
			}
		}
                
      // int imax = (int) (j*i-0.5);
           
       for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
				
			}
		}
            
        }
        
        static void heterogenous_distribution(int tabx[][]){
            
            
            	int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];    
			}
		}
                
      // int imax = (int) (j*i-0.5);
           
       for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
				
			}
		}
            
        }
	
	static void grains_amount(int tabx[][]){
            
            
            	int tab[][] = new int[MainPanel.s][MainPanel.s];
		for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				tab[i][j]=tabx[i][j];    
			}
		}
                
      // int imax = (int) (j*i-0.5);
           
       for(int i=0; i<MainPanel.s; i++){
			for(int j=0 ;j<MainPanel.s; j++){
				if(tab[i][j]!=0 && i>0 &&j>0 && i<MainPanel.s-1 && j<MainPanel.s-1){
					if(tab[i-1][j-1]==0)tabx[i-1][j-1]=tab[i][j];
					if(tab[i-1][j]==0)tabx[i-1][j]=tab[i][j];
					if(tab[i-1][j+1]==0)tabx[i-1][j+1]=tab[i][j];
					
					if(tab[i+1][j-1]==0)tabx[i+1][j-1]=tab[i][j];
					if(tab[i+1][j]==0)tabx[i+1][j]=tab[i][j];
					if(tab[i+1][j+1]==0)tabx[i+1][j+1]=tab[i][j];
					
					if(tab[i][j-1]==0)tabx[i][j-1]=tab[i][j];
					if(tab[i][j+1]==0)tabx[i][j+1]=tab[i][j];
				}
				if(period == true){
					if(i==0){
						if(tab[0][j]!=0) if(tabx[MainPanel.s-1][j]==0)tabx[MainPanel.s-1][j]=tab[0][j];
						if(tab[MainPanel.s-1][j]!=0)if(tabx[MainPanel.s-2][j]==0)tabx[MainPanel.s-2][j]=tab[MainPanel.s-1][j];
					}
					if(j==0){
						if(tab[i][0]!=0) if( tabx[i][MainPanel.s-1]==0)tabx[i][MainPanel.s-1]=tab[i][0];
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][MainPanel.s-2]==0)tabx[i][MainPanel.s-2]=tab[i][MainPanel.s-1];
					}
					if(i==MainPanel.s-1){
						if(tab[MainPanel.s-1][j]!=0) if( tabx[0][j]==0)tabx[0][j]=tab[MainPanel.s-1][j];
						if(tab[0][j]!=0)if(tabx[1][j]==0)tabx[1][j]=tab[0][j];
					}
					
					if(j==MainPanel.s-1){
						if(tab[i][MainPanel.s-1]!=0)if(tabx[i][0]==0) tabx[i][0]=tab[i][MainPanel.s-1];
						if(tab[i][0]!=0)if(tabx[i][1]==0)tabx[i][1]=tab[i][0];
					}
				}
				
			}
		}
            
        }
	
	
	
	
	
	
	}
	
	
	
	
	
	
	


