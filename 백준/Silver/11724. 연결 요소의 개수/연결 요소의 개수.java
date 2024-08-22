// BOJ 11724번 연결 요소의 개수
// https://www.acmicpc.net/problem/11724

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);
		}
		visited = new boolean[N + 1];

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		// 결과 출력
		System.out.println(count);
	}

	// dfs
	public static void dfs(int node) {
		visited[node] = true;
		for (int i = 0; i < adjList[node].size(); i++) {
			if (!visited[adjList[node].get(i)]) {
				visited[adjList[node].get(i)] = true;
				dfs(adjList[node].get(i));
			}
		}
	}
}
