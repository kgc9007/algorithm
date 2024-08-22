// BOJ 17626번 Four Squares
// https://www.acmicpc.net/problem/17626

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];
		dp[1] = 1;

		int idx = 2;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1];
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)]);
			}
			dp[i]++;
		}
		
		// 결과 출력
		System.out.println(dp[N]);
	}
}
