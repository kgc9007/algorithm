// BOJ 1826번 연료 채우기
// https://www.acmicpc.net/problem/1826

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 주유소의 개수 N

		int[][] stations = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			stations[i][0] = Integer.parseInt(st.nextToken());
			stations[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken()); // 마을까지의 거리 L
		int P = Integer.parseInt(st.nextToken()); // 트럭에 원래 있던 연료의 양 P

		Arrays.sort(stations, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});

		int count = 0;
		int curr = P;
		int idx = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while (curr < L) {
			for (int i = idx; i < N; i++) {
				if (curr < stations[i][0]) {
					break;
				}

				pq.add(stations[i][1]);
				idx++;
			}

			if (pq.isEmpty()) {
				count = -1;
				break;
			}
			int fuel = pq.poll();
			curr += fuel;
			count++;
		}

		System.out.println(count);
	}
}