
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] queue;
	public static int front = 0;
	public static int back = 0;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			
			if (com.equals("push")) {
				int item = Integer.parseInt(st.nextToken());
				push(item);
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
			if (com.equals("front")) {
				sb.append(front()).append('\n');
			}
			if (com.equals("back")) {
				sb.append(back()).append('\n');
			}
		}
		System.out.println(sb);
		
	}
	
	public static void push (int item) {
		queue[back] = item;
		back++;
	}
	
	public static int pop () {
		if (front<back) {
			int item = queue[front];
			queue[front] = 0;
			front++;
			return item;
		}
		else return -1;
	}
	
	public static int size() {
		return back - front;
	}
	
	public static int empty() {
		if (front<back) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public static int front() {
		if (front<back) {
			return queue[front];
		}
		else {
			return -1;
		}
	}
	
	public static int back() {
		if (front<back) {
			return queue[back-1];
		}
		else {
			return -1;
		}
	}
}
