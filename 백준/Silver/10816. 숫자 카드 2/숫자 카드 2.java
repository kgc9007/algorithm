// 10816번 숫자 카드 2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		list = new int[20000001];
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			int havingCard = Integer.parseInt(st.nextToken());
			list[havingCard+10000000]++;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<M; i++) {
			int check = Integer.parseInt(st.nextToken());
			sb.append(list[check+10000000]).append(' ');
		}
		System.out.println(sb);
	}
}
