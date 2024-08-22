
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		int j = 0;
		while (arr[N-1]==0) {
			for (int i=1; i<K; i++) {
				queue.add(queue.poll());
			}
			arr[j] = queue.poll();
			j++;
		}
		sb.append('<');
		for (int i=0; i<N-1; i++) {
			sb.append(arr[i]).append(", ");	
		}
		sb.append(arr[N-1]);
		sb.append('>');
		System.out.println(sb);
	}	
}
