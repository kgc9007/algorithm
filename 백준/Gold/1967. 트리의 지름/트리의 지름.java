// BOJ 1967번 트리의 지름
// https://www.acmicpc.net/problem/1967

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<int[]>[] graph;

	static boolean[] visited;

	static int maxIdx = 0;

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int ch = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[p].add(new int[] { ch, w });
			graph[ch].add(new int[] { p, w });
		}

		visited = new boolean[N + 1];
		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[N + 1];
		visited[maxIdx] = true;
		dfs(maxIdx, 0);

		// 결과 출력
		System.out.println(max);

	}

	// dfs
	public static void dfs(int start, int count) {
		if (count > max) {
			maxIdx = start;
			max = count;
		}

		for (int i = 0; i < graph[start].size(); i++) {
			int next = graph[start].get(i)[0];
			int w = graph[start].get(i)[1];

			if (!visited[next]) {
				visited[next] = true;
				dfs(next, count + w);
			}
		}
	}

}
