import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int min=64;
	public static boolean [][]map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new boolean [N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<str.length(); j++) {
				if (str.charAt(j)=='W') map[i][j] = true;
				else map[i][j] = false;
			}
		}
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				get_min(i, j);
			}
		}
		System.out.println(min);
		
	}
	public static void get_min(int x, int y) {
		int count=0;
		
		boolean criteria = map[x][y];
		
		for (int i=x; i<x+8; i++) {
			for (int j=y; j<y+8; j++) {
				if (map[i][j] != criteria) count++;
				criteria = !criteria;
			}
			criteria = !criteria;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}
}