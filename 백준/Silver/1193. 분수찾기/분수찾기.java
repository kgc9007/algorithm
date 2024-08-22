import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
			int X = in.nextInt();
			
			int sum=1;
			int plus=1;
			int d=1;
			
			while (true) {
				plus += d;
				
				if (X>=plus) {
					d++;
					sum++;
				}
				else {
					sum++;
					break;
				}
			}
			int num1;
			int num2;
			
			if (sum%2==1) {
				num1=1;
				num2=sum-1;
				for (int i=0; i<X-(plus-d); i++) {
					num1++;
					num2--;
				}
			}
			else {
				num1=sum-1;
				num2=1;
				for (int i=0; i<X-(plus-d); i++) {
					num1--;
					num2++;
				}
			}
			System.out.println(num1 + "/" + num2);
		}
}