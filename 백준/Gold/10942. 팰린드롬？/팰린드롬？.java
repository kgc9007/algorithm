// BOJ 10942번 팰린드롬?
// https://www.acmicpc.net/problem/10942

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 수의 개수 N

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// DP 테이블 생성
		// DP[s][e] : s번째부터 e번째까지의 수가 팰린드롬을 이루면 true, 아니라면 false
		boolean[][] DP = new boolean[N + 1][N + 1];
		// 길이 1인 경우 모두 팰린드롬
		for (int r = 1; r <= N; r++) {
			DP[r][r] = true;
		}
		for (int r = 1; r < N; r++) {
			// 길이가 홀수인 팰린드롬 확인
			for (int d = 1; d <= Math.min(r - 1, N - r); d++) {
				if (DP[r - d + 1][r + d - 1] && arr[r - d] == arr[r + d]) {
					DP[r - d][r + d] = true;
				}
			}

			// 길이가 짝수인 팰린드롬 확인
			if (arr[r] == arr[r + 1]) {
				DP[r][r + 1] = true;
				for (int d = 1; d <= Math.min(r - 1, N - r - 1); d++) {
					if (DP[r - d + 1][r + d] && arr[r - d] == arr[r + d + 1]) {
						DP[r - d][r + d + 1] = true;
					}
				}
			}
		}

		// 입력 -> 팰린드롬 확인 후 결과에 추가
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			if (DP[S][E]) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}

		}

		// 결과 출력
		System.out.println(sb);
	}
}
