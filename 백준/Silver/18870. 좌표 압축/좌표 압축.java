import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int[] sorted_list = new int[N]; 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			list[i] = sorted_list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted_list);
		
		HashMap<Integer, Integer> ranking_map = new HashMap<Integer, Integer>();
		int rank = 0;
		ranking_map.put(sorted_list[0], rank);
		rank++;
		for(int i=1; i<N; i++) {
			if(sorted_list[i]!=sorted_list[i-1]) {
				ranking_map.put(sorted_list[i], rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(ranking_map.get(list[i])).append(' ');
		}
		System.out.println(sb);
	}
}