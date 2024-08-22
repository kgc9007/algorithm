// BOJ 9095번 1, 2, 3 더하기
// https://www.acmicpc.net/problem/9095

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();

			System.out.println(dp[N]);
		}
	}
}
