// BOJ 9465번 스티커
// https://www.acmicpc.net/problem/9465

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[][] sticker = new int[2][N];
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					sticker[r][c] = sc.nextInt();
				}
			}

			int[][] dp = new int[2][N];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			for (int c = 1; c < N; c++) {
				dp[0][c] = Math.max(dp[0][c - 1], dp[1][c - 1] + sticker[0][c]);
				dp[1][c] = Math.max(dp[1][c - 1], dp[0][c - 1] + sticker[1][c]);
			}

			int max = Math.max(dp[0][N - 1], dp[1][N - 1]);

			// 결과 출력
			System.out.println(max);
		}
	}
}
