// BOJ 11000번 강의실 배정
// https://www.acmicpc.net/problem/11000

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
		int N = Integer.parseInt(br.readLine());

		int[][] lecture = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[i][0] = Integer.parseInt(st.nextToken());
			lecture[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(lecture, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lecture[0][1]);

		for (int i = 1; i < N; i++) {
			if (pq.peek() <= lecture[i][0]) {
				pq.poll();
			}

			pq.add(lecture[i][1]);
		}

		System.out.println(pq.size());
	}
}