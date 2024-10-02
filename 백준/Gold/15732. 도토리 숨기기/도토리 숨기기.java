// BOJ 15732번 도토리 숨기기
// https://www.acmicpc.net/problem/15732

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] rules = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rules[i][0] = Integer.parseInt(st.nextToken());
			rules[i][1] = Integer.parseInt(st.nextToken());
			rules[i][2] = Integer.parseInt(st.nextToken());
		}

		long left = 1;
		long right = N;

		while (left <= right) {
			long mid = (left + right) / 2;

			long count = 0;
			for (int i = 0; i < K; i++) {
				int start = rules[i][0];
				int end = rules[i][1];
				int diff = rules[i][2];

				if (mid < start) {
					continue;
				} else if (mid < end) {
					count += (mid - start) / diff + 1;
				} else {
					count += (end - start) / diff + 1;
				}
			}

			if (count >= D) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		// 결과 출력
		System.out.println(left);
	}

}
