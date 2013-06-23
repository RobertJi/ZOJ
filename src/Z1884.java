import java.util.Scanner;

// public class Main
public class Z1884 {
	
	private static char trans(char c ) {
		switch (c) {
		  case '1': return '`';
		  case '2': return '1';
		  case '3': return '2';
		  case '4': return '3';
		  case '5': return '4';
		  case '6': return '5';
		  case '7': return '6';
		  case '8': return '7';
		  case '9': return '8';
		  case '0': return '9';
		  case '-': return '0';
		  case '=': return '-';
		  case 'W': return 'Q';
		  case 'E': return 'W';
		  case 'R': return 'E';
		  case 'T': return 'R';
		  case 'Y': return 'T';
		  case 'U': return 'Y';
		  case 'I': return 'U';
		  case 'O': return 'I';
		  case 'P': return 'O';
		  case '[': return 'P';
		  case ']': return '[';
		  case '\\': return ']';
		  case 'S': return 'A';
		  case 'D': return 'S';
		  case 'F': return 'D';
		  case 'G': return 'F';
		  case 'H': return 'G';
		  case 'J': return 'H';
		  case 'K': return 'J';
		  case 'L': return 'K';
		  case ';': return 'L';
		  case '\'': return ';';
		  case 'X': return 'Z';
		  case 'C': return 'X';
		  case 'V': return 'C';
		  case 'B': return 'V';
		  case 'N': return 'B';
		  case 'M': return 'N';
		  case ',': return 'M';
		  case '.': return ',';
		  case '/': return '.';
		  case ' ': return ' ';
		  default:return ' ';
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.nextLine();
			
			for ( int i = 0;i < s.length();i++) {
				char c = s.charAt(i);
				System.out.print(trans(c));
			}
			System.out.println();
			
		}
	}
}


