// BOJ 11727번 2xn 타일링 2
// https://www.acmicpc.net/problem/11727

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[1001];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}

		// 결과 출력
		System.out.println(dp[N]);
	}
}
