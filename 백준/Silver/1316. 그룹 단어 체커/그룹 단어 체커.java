import java.util.Scanner;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int count=0;
		
		for (int i=0; i<N; i++) {
			String word = in.next();
			char[] arr = new char[word.length()];
			int change1=0;
			int change2=0;
			
			for (int j=0; j<word.length(); j++) {
				arr[j]=word.charAt(j);
			}

			Arrays.sort(arr);
			
			for (int j=1; j<word.length(); j++) {
				if (arr[j]==arr[j-1]) change1++;
			}
			
			for (int j=1; j<word.length(); j++) {
				if (word.charAt(j)==word.charAt(j-1)) change2++;
			}
			
			if (change1==change2) count++;
		}
		
		System.out.println(count);
	}
}