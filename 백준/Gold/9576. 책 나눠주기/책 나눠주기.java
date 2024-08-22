// BOJ 9576번 책 나눠주기
// https://www.acmicpc.net/problem/9576

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

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[1] - o2[1];
				}
			});

			int count = 0;
			boolean[] visited = new boolean[N + 1];
			for (int i = 0; i < M; i++) {
				int left = arr[i][0];
				int right = arr[i][1];

				for (int j = left; j <= right; j++) {
					if (!visited[j]) {
						visited[j] = true;
						count++;
						break;
					}
				}

			}

			// 결과 출력
			System.out.println(count);
		}

	}
}
