// BOJ 2623번 음악프로그램
// https://www.acmicpc.net/problem/2623

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> result = new ArrayList<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		int[] inDegree = new int[N + 1];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int K = Integer.parseInt(st.nextToken());

			int start = Integer.parseInt(st.nextToken());
			for (int i = 1; i < K; i++) {
				int end = Integer.parseInt(st.nextToken());

				adj[start].add(end);
				inDegree[end]++;

				start = end;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			result.add(curr);

			for (Integer next : adj[curr]) {
				inDegree[next]--;

				if (inDegree[next] == 0) {
					queue.add(next);
				}
			}
		}

		// 결과 출력
		if (result.size() != N) {
			System.out.println(0);
		} else {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}
}
