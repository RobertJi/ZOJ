import java.util.Scanner;
//设n个人围成一圈，标号为0..n-1，从第一个人开始依次从1到k循环报数，当报到k的
//时候此人出圈。设J(n, k, i)表示第i个出圈的人的标号。
//
//定理一:
//J(n, k, 1) = (k-1) MOD n, (n>=1, k>=1) ………… (1)
//
//证明：由定义直接得证。
//
//定理二：
//J(n+1, k, i+1) = (k + J(n, k, i)) MOD (n+1),  (n>=1, k>=1, 1<=i<=n) ………
//… (2)

public class Z1088 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int a = in.nextInt();
			if ( a == 0 ) break;
			for ( int k = 1;;k++) {
				// Try m
				// Target : J(a,m,a) = 2
				// Initial : J(1,m,1) = 0
				int s = 0;
				for ( int i = 2;i < a;i++) {
					// Calc J(i,m,i)
					s = (k+s) % i;
				}
				if ( s == 0 ) {
					System.out.println(k);
					break;
				}
			}
		}
	}

}
