// BOJ 18352번 특정 거리의 도시 찾기
// https://www.acmicpc.net/problem/18352

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static List<Integer>[] adj;
	static int[] visited;

	static int K;
	static int X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			int S = sc.nextInt();
			int E = sc.nextInt();

			adj[S].add(E);
		}

		visited = new int[N + 1];
		bfs(X);

		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K + 1) {
				result.add(i);
			}
		}
		
		Collections.sort(result);

		// 결과 출력
		if (result.size() == 0) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}

	// bfs
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < adj[curr].size(); i++) {
				if (visited[adj[curr].get(i)] == 0) {
					visited[adj[curr].get(i)] = visited[curr] + 1;
					queue.add(adj[curr].get(i));
				}
			}
		}

	}
}
