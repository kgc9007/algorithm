// BOJ 1781번 컵라면
// https://www.acmicpc.net/problem/1781

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
		int[][] noodles = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			noodles[i][0] = Integer.parseInt(st.nextToken());
			noodles[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(noodles, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});

		int sum = 0;
		int day = noodles[0][0];
		int idx = 0;

		while (day >= 1) {
			while (idx < N && noodles[idx][0] == day) {
				pq.add(noodles[idx++]);
			}
			day--;
			if (pq.isEmpty()) {
				continue;
			}
			int[] noodle = pq.poll();

			sum += noodle[1];
		}

		// 결과 출력
		System.out.println(sum);
	}
}
