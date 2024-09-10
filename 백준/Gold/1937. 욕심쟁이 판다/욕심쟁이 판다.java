// BOJ 1937번 욕심쟁이 판다
// https://www.acmicpc.net/problem/1937

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int N;
	static int[][] map;

	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][N];
		int ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				ans = Math.max(ans, dfs(r, c));
			}
		}

		// 결과 출력
		System.out.println(ans);

	}

	// dfs
	public static int dfs(int r, int c) {
		if (dp[r][c] != 0) {
			return dp[r][c];
		}

		dp[r][c] = 1;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}

			if (map[r][c] >= map[nr][nc]) {
				continue;
			}

			dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
		}

		return dp[r][c];
	}
}
