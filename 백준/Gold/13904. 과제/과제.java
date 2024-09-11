// BOJ 13904번 과제
// https://www.acmicpc.net/problem/13904

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		int lastDay = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

			lastDay = Math.max(lastDay, arr[i][0]);
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o2[0] - o1[0];
			}
		});

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});

		int score = 0;
		int day = lastDay;
		int idx = 0;
		while (day > 0) {
			while (idx < N && arr[idx][0] >= day) {
				pq.add(arr[idx++]);
			}

			if (!pq.isEmpty()) {
				score += pq.poll()[1];
			}

			day--;
		}

		// 결과 출력
		System.out.println(score);

	}
}
