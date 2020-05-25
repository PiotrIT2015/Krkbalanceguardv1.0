

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author as
 */
public class Bmi {
    
        String imie;
	double waga;
	double wzrost;
        double wynik;

	//Scanner sc = new Scanner(System.in);
	 
	
	Bmi(){
         
	//	imie=sc.nextLine();
	//	waga=sc.nextDouble();
	//	wzrost=sc.nextDouble();
        }
        
        public void setA(double A){wzrost=A;}
        public double getA(){return wzrost;}
        public void setB(double B){waga=B;}
        public double getB(){return waga;}
        public void setwynik(){wynik=Wskaznik(waga,wzrost);}
        public double getwynik(){return wynik;}
           
           
          double Wskaznik(double a, double b){
    	double masa=a;
    	double wysokosc=b;
    	wysokosc=wysokosc/100;
    	System.out.println("Twoj wzrost to" + wysokosc);
        double BMI=masa/(Math.pow(wysokosc, 2));
         return BMI;
         
    }
    
}