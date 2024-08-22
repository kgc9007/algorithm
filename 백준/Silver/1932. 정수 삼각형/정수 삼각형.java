// BOJ 1932번 정수 삼각형
// https://www.acmicpc.net/problem/1932

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] triangle = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < r + 1; c++) {
				triangle[r][c] = sc.nextInt();
			}
		}

		int[][] dp = new int[N][N];
		dp[0][0] = triangle[0][0];
		for (int r = 1; r < N; r++) {
			dp[r][0] = dp[r - 1][0] + triangle[r][0];
			dp[r][r] = dp[r - 1][r - 1] + triangle[r][r];
		}
		for (int r = 2; r < N; r++) {
			for (int c = 1; c < r; c++) {
				dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r - 1][c]) + triangle[r][c];
			}
		}

		int max = 0;
		for (int c = 0; c < N; c++) {
			max = Math.max(max, dp[N - 1][c]);
		}
		
		// 결과 출력
		System.out.println(max);
	}
}
