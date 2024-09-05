// BOJ 1753번 최단경로
// https://www.acmicpc.net/problem/1753

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	static int V; // 정점의 개수 V
	static int E; // 간선의 개수 E
	static int K; // 시작 정점의 번호 K

	static List<int[]>[] adj; // 인접 리스트 - 그래프

	static int[] dist; // 최소 거리 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		adj = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<int[]>();
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[s].add(new int[] { e, w });
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		
		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	public static void dijkstra(int start) {
		boolean[] visited = new boolean[V + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		dist[start] = 0;
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int v = curr[0];
			int w = curr[1];

			if (!visited[v]) {
				visited[v] = true;

				for (int[] next : adj[v]) {
					int nv = next[0];
					int nw = next[1];

					if (!visited[nv] && dist[v] + nw < dist[nv]) {
						dist[nv] = dist[v] + nw;
						pq.add(new int[] { nv, dist[nv] });
					}
				}
			}
		}
	}
}
