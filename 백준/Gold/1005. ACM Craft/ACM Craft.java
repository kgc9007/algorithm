// BOJ 1005번 ACM Craft
// https://www.acmicpc.net/problem/1005

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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] buildings = new int[N + 1];
			int[] inDegree = new int[N + 1];
			int[] visited = new int[N + 1];
			List<Integer>[] adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<Integer>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				adj[start].add(end);
				inDegree[end]++;
			}

			int W = Integer.parseInt(br.readLine());

			Queue<int[]> queue = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) {
					visited[i] = buildings[i];
					queue.add(new int[] { i, visited[i] });
				}
			}

			while (!queue.isEmpty()) {
				int[] curr = queue.poll();

				if (curr[0] == W) {
					sb.append(curr[1]).append('\n');
					break;
				}

				for (int i : adj[curr[0]]) {
					inDegree[i]--;
					visited[i] = Math.max(visited[i], curr[1] + buildings[i]);

					if (inDegree[i] == 0) {
						queue.add(new int[] { i, visited[i] });
					}
				}
			}

		}

		// 결과 출력
		System.out.println(sb);
	}
}
