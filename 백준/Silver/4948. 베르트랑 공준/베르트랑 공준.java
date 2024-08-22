import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static boolean[] prime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		prime = new boolean[123456*2+1];
		get_prime();
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			for (int j=n+1; j<=2*n; j++) {
				if (!prime[j]) count++;
			}
			if (n==0) break;
			System.out.println(count);
		}
	}	
	
	public static void get_prime() {
		prime[0] = true;
		prime[1] = true;
		
		for (int i=2; i<Math.sqrt(prime.length); i++) {
			if (prime[i]) continue;
			
			for (int j=i*i; j<prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
	}
	
}