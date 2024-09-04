// BOJ 9084번 동전
// https://www.acmicpc.net/problem/9084

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine()); // 동전의 수 N

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] coins = new int[N];
			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine()); // 주어진 금액 M

			int[] DP = new int[M + 1];
			DP[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = coins[i]; j <= M; j++) {
					DP[j] += DP[j - coins[i]];
				}
			}

			sb.append(DP[M]).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}
}
