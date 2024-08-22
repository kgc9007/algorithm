import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
	public static boolean[] prime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		prime = new boolean[10001];
		get_prime();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			int half = n/2;
			int p=0;
			while (true) {
				if ((prime[half-p]==false)&&(prime[half+p]==false)) {
					System.out.println((half-p) + " " + (half+p));
					break;
				}
				p++;
			}
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