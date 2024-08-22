// BOJ 9251번 LCS
// https://www.acmicpc.net/problem/9251

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		int[][] dp = new int[arr1.length + 1][arr2.length + 1];

		for (int r = 1; r <= arr1.length; r++) {
			for (int c = 1; c <= arr2.length; c++) {
				if (arr1[r - 1] == arr2[c - 1]) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}

		// 결과 출력
		System.out.println(dp[arr1.length][arr2.length]);
	}
}
