import java.util.Scanner;

// public class Main
public class Z1115 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String b = in.nextLine().trim();
			if (b.equals("0") ) break;
			int sum = 0;
			for(int i = 0;i < b.length();i++) {
				sum += (b.charAt(i) - '0');
			}
			while ( sum >= 10 ) {
				int a = sum % 10;
				while(sum >= 10 ) {
					sum/=10;
					a+=(sum%10);
					
				}
				sum=a;
			}
			
			System.out.println(sum);
		}
	}
}


