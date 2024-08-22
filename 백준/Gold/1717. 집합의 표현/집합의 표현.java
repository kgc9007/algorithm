// BOJ 1717번 집합의 표현
// https://www.acmicpc.net/problem/1717

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (command == 0) {
				union(x, y);
			} else {
				if (find(x) == find(y)) {
					sb.append("YES").append('\n');
				} else {
					sb.append("NO").append('\n');
				}
			}
		}
		
		// 결과 출력
		System.out.println(sb);
	}

	// find
	public static int find(int x) {
		if (x != parents[x]) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}

	// union
	public static void union(int x, int y) {
		parents[find(x)] = find(y);
	}
}
