
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static int N;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while ((str = br.readLine()) != null) {
			N = Integer.parseInt(str);
			int len = (int) Math.pow(3, N);
			
			sb = new StringBuilder();
			for (int i=0; i<len; i++) {
				sb.append("-");
			}
			get_Cantor_Set(0, len);
			System.out.println(sb);
		}
		
	}
	
	public static void get_Cantor_Set (int start, int len) {	
		if (len==1) {
			return;
		}
		int newLen = len/3;
		
		for (int i = start + newLen; i<start + 2*newLen; i++) {
			sb.setCharAt(i,  ' ');
		}
		get_Cantor_Set(start, newLen);
		get_Cantor_Set(start + 2*newLen, newLen);
	}	
}