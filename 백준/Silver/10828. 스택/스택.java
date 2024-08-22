import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static int []stack;
	public static int size = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		stack = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			
			if (com.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				push(num);
			}
			if (com.equals("pop")) {
				sb.append(pop()).append('\n');
			}
			if (com.equals("size")) {
				sb.append(size()).append('\n');
			}
			if (com.equals("empty")) {
				sb.append(empty()).append('\n');
			}
			if (com.equals("top")) {
				sb.append(top()).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static void push(int X) {
		stack[size] = X;
		size++;
	}
	
	public static int pop() {
		if (size == 0) {
			return -1;
		}
		else {
			int top = stack[size-1];
			stack[size-1] = 0;
			size--;
			return top;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size == 0) return 1;
		else return 0;
	}
	
	public static int top() {
		if (size == 0) return -1;
		else return stack[size-1];
	}
}