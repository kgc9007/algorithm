// BOJ 1167번 트리의 지름
// https://www.acmicpc.net/problem/1167

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int to;
	int w;

	Edge(int to, int w) {
		this.to = to;
		this.w = w;
	}
}

public class Main {

	static int V;
	static List<Edge>[] adj;

	static boolean[] visited;
	static int maxIdx;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());

		adj = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) {
					break;
				}

				int w = Integer.parseInt(st.nextToken());

				adj[N].add(new Edge(to, w));
				adj[to].add(new Edge(N, w));
			}
		}

		visited = new boolean[V + 1];
		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[V + 1];
		visited[maxIdx] = true;
		dfs(maxIdx, 0);

		// 결과 출력
		System.out.println(max);

	}

	// dfs
	public static void dfs(int idx, int length) {
		if (length > max) {
			maxIdx = idx;
			max = length;
		}

		for (int i = 0; i < adj[idx].size(); i++) {
			if (!visited[adj[idx].get(i).to]) {
				visited[adj[idx].get(i).to] = true;
				dfs(adj[idx].get(i).to, length + adj[idx].get(i).w);
			}
		}
	}

}
