import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int[] deque;
	public static int front;
	public static int back;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		deque = new int[N*2];
		front = N;
		back = N;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch (st.nextToken()) {
				case "push_front": 
				push_front(Integer.parseInt(st.nextToken()));
				break;
				
				case "push_back": 
				push_back(Integer.parseInt(st.nextToken()));
				break;

				case "pop_front": 
				sb.append(pop_front()).append('\n');
				break;

				case "pop_back": 
				sb.append(pop_back()).append('\n');
				break;
				
				case "size":
				sb.append(size()).append('\n');
				break;

				case "empty":
				sb.append(empty()).append('\n');
				break;

				case "front":
				sb.append(front()).append('\n');
				break;

				case "back":
				sb.append(back()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
	public static void push_front (int X) {
		deque[front-1] = X;
		front--;
	}
	public static void push_back (int X) {
		deque[back] = X;
		back++;
	}
	public static int pop_front () {
		if (front==back) return -1;
		else {
			int item = deque[front];
			deque[front] = 0;
			front++;
			return item;
		}
	}
	public static int pop_back () {
		if (front==back) return -1;
		else {
			int item = deque[back-1];
			deque[back-1] = 0;
			back--;
			return item;
		}
	}
	public static int size() {
		return back-front;
	}
	public static int empty() {
		if (front==back) return 1;
		else return 0;
	}
	public static int front() {
		if (front==back) return -1;
		else return deque[front];
	}
	public static int back() {
		if (front==back) return -1;
		else return deque[back-1];
	}
}