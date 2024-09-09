// BOJ 1562번 계단 수
// https://www.acmicpc.net/problem/1562

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][][] dp = new long[N + 1][10][1 << 10];
		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < (1 << 10); k++) {
					int currBit = k | (1 << j);

					if (j == 0) {
						dp[i][j][currBit] += dp[i - 1][j + 1][k] % MOD;
					} else if (j == 9) {
						dp[i][j][currBit] += dp[i - 1][j - 1][k] % MOD;
					} else {
						dp[i][j][currBit] += dp[i - 1][j - 1][k] % MOD + dp[i - 1][j + 1][k] % MOD;
					}

					dp[i][j][currBit] %= MOD;
				}
			}
		}

		long result = 0;
		for (int i = 0; i < 10; i++) {
			result += dp[N][i][(1 << 10) - 1];
			result %= MOD;
		}

		// 결과 출력
		System.out.println(result);
	}
}
