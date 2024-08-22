import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 666;
		while (N!=1) {
			result++;
			if (String.valueOf(result).contains("666")) {
				N--;
			}
		}
		System.out.println(result);
	}
}