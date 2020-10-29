package Linear;
import java.util.*;
public class LUD {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		double a [][] = new double [5][5];
		double b []	  = new double [5];
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j<5; j++) {
				System.out.print("a"+i+j+"=");
				a[i-1][j-1] = sc.nextInt();
			}
		System.out.print("b"+i+"=");
		b[i-1] = sc.nextInt();
		}
	double[][] l = findL(a);
	double[][] u = forwardElim(a);
	double[] z = backSub(l,b);
	double[] x = backSub(u,z);
	System.out.println("Array L"); printArray(l);
	System.out.println("Array U"); printArray(u);
	System.out.println("Array Z");
	for(int i = 1; i <= 4; i++) {
		System.out.printf("z"+i+"="+"%5.4f", x[i-1]);
		System.out.println();
		}
	System.out.println("Array X");
	for (int i = 1; i <= 4; i++) {
		System.out.printf("x"+i+"="+"%5.4f",x[i-1]);
		System.out.println();
		}
	}
	
public static double [][] forwardElim (double [][] a){
	for(int i = 0; i < 4; i++) {
		for(int j = i+1; j < 4; j++) {
			double temp = a[j][i] / a[i][i];
				for (int k = i; k < 4; k++) {
					a[j][k] -= temp * a[i][k];
				}
		}
	}
	return a;
}
public static double [][] findL (double [][] a){
	double [][] c = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
	c[1][0] = a[1][0]/a[0][0];
	c[2][0] = a[2][0]/a[0][0];
	c[3][0] = a[3][0]/a[0][0];
	double temp1 = a[1][1]-(c[1][0]*a[0][1]);
	double temp2 = a[2][1]-(c[2][0]*a[0][1]);
	double temp3 = a[3][1]-(c[3][0]*a[0][1]);
	c[2][1] = temp2/temp1;
	c[3][1] = temp3/temp1;
	return c;
	}
public static double[] backSub (double[][] a, double[] b) {
	double [] x = new double[4];
	if (a[3][0] == 0) {
		for (int i = 3; i>= 0; i--) {
			double sum = 0;
				for (int j = i + 1; j < 4; j++) {
					sum += a[i][j] * x[j];
				}
			x[i] = (b[i]-sum)/a[i][i];
		}
	}
		return x;
}
public static void printArray (double[][] arr) {
	for (int i = 0; i < 4; i++) {
		System.out.print("[");
			for(int j = 0; j < 4; j++) {
				System.out.print(arr[i][j]+ " ");
			}
		System.out.println("]");
		}
	}
}
