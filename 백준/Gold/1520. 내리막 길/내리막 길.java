// BOJ 1520번 내리막길
// https://www.acmicpc.net/problem/1520

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;

	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][M];
		for (int r = 0; r < N; r++) {
			Arrays.fill(dp[r], -1);
		}

		// 결과 출력
		System.out.println(dfs(0, 0));

	}

	// [DFS]
	public static int dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return 1;
		}

		if (dp[r][c] == -1) {
			dp[r][c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (map[r][c] <= map[nr][nc]) {
					continue;
				}

				dp[r][c] += dfs(nr, nc);
			}
		}

		return dp[r][c];
	}
}
