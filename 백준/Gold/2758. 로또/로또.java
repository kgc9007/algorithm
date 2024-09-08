// BOJ 2758번 로또
// https://www.acmicpc.net/problem/2758

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long[][] dp = new long[11][2001];

		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for (int i = 2; i <= 10; i++) {
			for (int j = 1; j <= 2000; j++) {
				if (dp[i - 1][j] != 0) {
					for (int k = j * 2; k <= 2000; k++) {
						dp[i][k] += dp[i - 1][j];
					}
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			long result = 0;
			for (int i = 1; i <= M; i++) {
				result += dp[N][i];
			}

			System.out.println(result);
		}

	}
}
