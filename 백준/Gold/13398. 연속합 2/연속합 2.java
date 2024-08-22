// BOJ 13398번 연속합 2
// https://www.acmicpc.net/problem/13398

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[][] dp = new int[N + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = arr[1];
		dp[1][0] = arr[1];
		dp[1][1] = arr[1];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
			max = Math.max(max, dp[i][0]);
			max = Math.max(max, dp[i][1]);
		}

		// 결과 출력
		System.out.println(max);
	}
}
