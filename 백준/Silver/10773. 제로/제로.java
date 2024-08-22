import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int []stack = new int [K];
		int top = 0;
		
		for(int i=0; i<K; i++) {
			int item = Integer.parseInt(br.readLine());
			
			if (!(item==0)) {
				stack[top] = item;
				top++;
			}
			else {
				stack[top] = 0;
				top--;
			}
			
		}
		int sum = 0;
		
		for (int i=0; i<top; i++) {
			sum += stack[i];
		}
		System.out.println(sum);
	}

}