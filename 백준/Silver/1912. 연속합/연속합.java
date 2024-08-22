// BOJ 1912번 연속합

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		
		int max = Integer.MIN_VALUE;
		dp[0] = num[0];
		max = Math.max(max, dp[0]);
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
			max = Math.max(max, dp[i]);
		}
		
		// 결과 출력
		System.out.println(max);
	}
}
