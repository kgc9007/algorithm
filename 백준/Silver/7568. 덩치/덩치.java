import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
	public static int []rank;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int []height = new int[N];
		int []weight = new int[N];
		rank = new int[N];
		for (int i=0; i<N; i++) {
			rank[i]=1;
		}
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			height [i] = Integer.parseInt(st.nextToken());
			weight [i] = Integer.parseInt(st.nextToken());
		}
		
		get_rank(height, weight);
		
		for (int i=0; i<N; i++) {
			bw.write(rank[i]+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static void get_rank(int []height, int []weight) {
		for (int i=0; i<height.length; i++) {
			for (int j=0; j<height.length; j++) {
				if (height[i]<height[j]&&weight[i]<weight[j]) {
					rank[i]++;
				}
			}
		}
	}
}