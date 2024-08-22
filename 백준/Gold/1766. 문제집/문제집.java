// BOJ 1766번 문제집
// https://www.acmicpc.net/problem/1766

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		int[] inDegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adj[start].add(end);
			inDegree[end]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				pq.add(i);
				visited[i] = true;
			}
		}
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			sb.append(curr).append(" ");

			for (int i = 0; i < adj[curr].size(); i++) {
				int next = adj[curr].get(i);
				inDegree[next]--;

				if (!visited[next] && inDegree[next] == 0) {
					pq.add(next);
				}
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}
