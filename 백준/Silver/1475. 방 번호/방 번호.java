import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] count = new int[10];
		
		while (N > 0){
			count[N % 10]++;
			N /= 10;
		}
		
		int max = 0;
		for (int i = 0; i < 10; i++) {
			if (i != 6 && i != 9) {
				max = Math.max(max, count[i]);
			} else {
				if ((count[6] + count[9]) % 2 == 0) {
					max = Math.max(max, (count[6] + count[9]) / 2);					
				} else {
					max = Math.max(max, (count[6] + count[9]) / 2 + 1);	
				}
			}
		}
		
		System.out.println(max);
	}
}
