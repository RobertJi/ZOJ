import java.util.Scanner;
import static java.lang.Math.pow;

class Triangle{
	public static final double PAI = 3.14159265358;
 private double bc1,bc2,bc3;

 public double grith(){
  return bc1+bc2+bc3;
 }

 double area()
 {
  double area;
  double p=(bc1+bc2+bc3)/2;
  area = pow( p*(p-bc1)*(p-bc2)*(p-bc3),0.5);
  return area;
 }

 double incirclearea()
 {
  double r,insidearea;
  double area;
  double p=(bc1+bc2+bc3)/2;
  area= pow(p*(p-bc1)*(p-bc2)*(p-bc3),0.5);
  r=2*area/(bc1+bc2+bc3);
  insidearea= PAI*r*r;
  return insidearea;
 }

 double circumcirclearea(){
  double R,outsidearea;
  double area;
  double p=(bc1+bc2+bc3)/2;
  area= pow(p*(p-bc1)*(p-bc2)*(p-bc3),0.5);
  R=bc1*bc2*bc3/(4*area);
  outsidearea=PAI*R*R;
  return outsidearea;
 }

 void setAttribute(double x,double y,double z)
 {
  bc1=x;
  bc2=y;
  bc3=z;
 }
};

// public class Main
public class Z1439 {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			double x1 = in.nextInt();
			double y1 = in.nextInt();
			double z1 = in.nextInt();
			double x2 = in.nextInt();
			double y2 = in.nextInt();
			double z2 = in.nextInt();
			double x3 = in.nextInt();
			double y3 = in.nextInt();
			double z3 = in.nextInt();

			 
			double ba1 = pow( (x1 - x2 )*(x1-x2)+(y1 - y2 )*(y1-y2)+(z1 - z2 )*(z1-z2) , 0.5 );
			double ba2 = pow( (x1 - x3 )*(x1-x3)+(y1 - y3 )*(y1-y3)+(z1 - z3 )*(z1-z3) , 0.5 );
			double ba3 = pow( (x2 - x3 )*(x2-x3)+(y2 - y3 )*(y2-y3)+(z2 - z3 )*(z2-z3) , 0.5 );
			
			Triangle tr = new Triangle();
			tr.setAttribute(ba1, ba2, ba3);
			String s = String.format("%.3f",  tr.incirclearea() / tr.circumcirclearea() );
			System.out.println(s);
		}
	}
}


