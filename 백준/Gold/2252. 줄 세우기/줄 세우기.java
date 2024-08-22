// BOJ 2252번 줄 세우기
// https://www.acmicpc.net/problem/2252

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
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		int[] inDegree = new int[N + 1];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adj[start].add(end);
			inDegree[end]++;
		}

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				visited[i] = true;
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");

			for (int i = 0; i < adj[curr].size(); i++) {
				int next = adj[curr].get(i);
				inDegree[next]--;

				if (!visited[next] && inDegree[next] == 0) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}
