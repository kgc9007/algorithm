// BOJ 11048번 이동하기
// https://www.acmicpc.net/problem/11048

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] map;

	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + map[r][c];
			}
		}
		
		// 결과 출력
		System.out.println(dp[N][M]);
	}
}
