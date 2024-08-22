import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		String word = in.next();
		
		int count = 0;
		
		for (int i=0; i<word.length(); i++) {
			
			if (word.charAt(i)=='c') {
				if(i<word.length()-1) {
					if (word.charAt(i+1)=='=') {
						i++;
					}
					else if (word.charAt(i+1)=='-') {
						i++;
					}
				}
			}
			
			else if (word.charAt(i)=='d') {
				if(i<word.length()-1) {
					if (word.charAt(i+1)=='z') {
						if (i<word.length()-2) {
							if (word.charAt(i+2)=='=') {
								i += 2;
							}
						}
					}
					else if (word.charAt(i+1)=='-') {
						i++;
					}
				}
			}
			
			else if (word.charAt(i)=='l') {
				if (i<word.length()-1) {
					if (word.charAt(i+1)=='j') {
						i++;
					}
				}
			}
			
			else if (word.charAt(i)=='n') {
				if (i<word.length()-1) {
					if (word.charAt(i+1)=='j') {
						i++;
					}
				}
			}
			
			else if (word.charAt(i)=='s') {
				if (i<word.length()-1) {
					if (word.charAt(i+1)=='=') {
						i++;
					}
				}
			}
			
			else if (word.charAt(i)=='z') {
				if (i<word.length()-1) {
					if (word.charAt(i+1)=='=') {
						i++;
					}
				}
			}
			count++;
		}
		System.out.println(count);
	}
}