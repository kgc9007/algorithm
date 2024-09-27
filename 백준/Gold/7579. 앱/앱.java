// BOJ 7579번 앱
// https://www.acmicpc.net/problem/7579

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 현재 활성화되어 있는 앱의 수
		int M = Integer.parseInt(st.nextToken()); // 필요한 메모리의 크기

		// app[i][0] : 사용중인 메모리, app[i][1] : 비활성활 했을 경우의 비용
		int[][] app = new int[N][2];
		int max = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			app[i][0] = Integer.parseInt(st1.nextToken());
			app[i][1] = Integer.parseInt(st2.nextToken());
			max += app[i][1];
		}

		int result = Integer.MAX_VALUE;
		int[][] DP = new int[N][max + 1];
		for (int r = 0; r < N; r++) {
			int cost = app[r][1];
			int memory = app[r][0];

			for (int c = 0; c <= max; c++) {
				if (r == 0) {
					if (c >= cost) {
						DP[r][c] = memory;
					}
				} else {
					if (c >= cost) {
						DP[r][c] = Math.max(DP[r - 1][c], DP[r - 1][c - cost] + memory);
					} else {
						DP[r][c] = DP[r - 1][c];
					}
				}

				if (DP[r][c] >= M) {
					result = Math.min(result, c);
				}
			}
		}

		// 결과 출력
		System.out.println(result);
	}
}
