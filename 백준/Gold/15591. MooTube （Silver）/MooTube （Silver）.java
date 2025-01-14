// BOJ 15591번 MooTube (Silver)
// https://www.acmicpc.net/problem/15591

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int N;
	static int Q;

	static List<Node>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Node>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			adj[p].add(new Node(q, r));
			adj[q].add(new Node(p, r));
		}

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			sb.append(getRecommCnt(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			sb.append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	public static int getRecommCnt(int k, int v) {
		int cnt = 0;

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (Node node : adj[curr]) {
				if (!visited[node.v] && node.w >= k) {
					queue.add(node.v);
					visited[node.v] = true;
					cnt++;
				}
			}
		}

		return cnt;

	}

}
