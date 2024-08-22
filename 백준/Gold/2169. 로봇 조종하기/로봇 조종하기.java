// BOJ 2169번 로봇 조종하기
// https://www.acmicpc.net/problem/2169

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N][M][3];
		dp[0][0][0] = map[0][0];
		dp[0][0][1] = map[0][0];
		dp[0][0][2] = map[0][0];
		for (int c = 1; c < M; c++) {
			dp[0][c][0] = dp[0][c - 1][0] + map[0][c];
		}

		for (int r = 1; r < N; r++) {
			for (int c = 0; c < M; c++) {
				dp[r][c][1] = dp[r - 1][c][0] + map[r][c];
				dp[r][c][2] = dp[r - 1][c][0] + map[r][c];
			}

			for (int c = 1; c < M; c++) {
				dp[r][c][1] = Math.max(dp[r][c - 1][1] + map[r][c], dp[r][c][1]);
			}
			for (int c = M - 2; c >= 0; c--) {
				dp[r][c][2] = Math.max(dp[r][c + 1][2] + map[r][c], dp[r][c][2]);
			}
			for (int c = 0; c < M; c++) {
				dp[r][c][0] = Math.max(dp[r][c][1], dp[r][c][2]);
			}
		}
		
		// 결과 출력
		System.out.println(dp[N- 1][M - 1][0]);
	}
}
