// BOJ 10800번 컬러볼
// https://www.acmicpc.net/problem/10800

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] balls = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			balls[i][0] = i;
			balls[i][1] = Integer.parseInt(st.nextToken());
			balls[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(balls, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		int[] result = new int[N + 1];
		int[] score = new int[N + 1];
		int idx = 1;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			while (balls[idx][2] < balls[i][2]) {
				sum += balls[idx][2];
				score[balls[idx][1]] += balls[idx][2];
				idx++;
			}
			result[balls[i][0]] = sum - score[balls[i][1]];
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append('\n');
		}
		
		System.out.println(sb);
	}
}
