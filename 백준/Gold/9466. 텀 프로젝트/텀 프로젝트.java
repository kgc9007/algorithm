// BOJ 9466번 텀 프로젝트
// https://www.acmicpc.net/problem/9466

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] visited;
	static boolean[] checked;

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[N + 1];
			checked = new boolean[N + 1];
			count = 0;
			for (int i = 1; i <= N; i++) {
				if (!checked[i]) {
					dfs(i);
				}
			}

			sb.append(N - count).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	// dfs
	public static void dfs(int curr) {
		if (visited[curr]) {
			checked[curr] = true;
			count++;
		} else {
			visited[curr] = true;
		}

		if (!checked[arr[curr]]) {
			dfs(arr[curr]);
		}

		visited[curr] = false;
		checked[curr] = true;

	}
}
