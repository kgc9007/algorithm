// BOJ 2606번 바이러스

import java.util.Scanner;

public class Main {

	static boolean[][] graph;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 컴퓨터의 수(노드의 수) N, 네트워크에서 직접 연결되어 있는 컴퓨터 쌍의 수(간선의 수) L 입력
		int N = sc.nextInt();
		int L = sc.nextInt();

		graph = new boolean[N][N];
		visited = new boolean[N];

		while (L-- > 0) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;
			
			graph[s][e] = true;
			graph[e][s] = true;
		}

		count = 0;
		dfs(0);
		
		System.out.println(count - 1);
	}

	public static void dfs(int node) {
		count++;
		visited[node] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[node][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
}
