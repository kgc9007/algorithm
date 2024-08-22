// BOJ 2579번 계단 오르기

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}

		// 
		int[] dp = new int[N];

		//
		dp[0] = score[0];
		
		//
		if (N >= 2) {
			dp[1] = Math.max(score[0] + score[1], score[1]);
		}
		if (N >= 3) {
			dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);			
		}

		// 
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
		}
		
		System.out.println(dp[N - 1]);
	}
}
