import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			String str = br.readLine();
			
			sb.append(test(str)).append('\n');
			
		}
		System.out.println(sb);
		
	}
	
	public static String test(String str) {
		int count = 0;
		
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)=='(') {
				count++;
			}
			else if (count == 0) {
				return "NO";
			}
			else {
				count--;
			}
		}
		if (count == 0) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
