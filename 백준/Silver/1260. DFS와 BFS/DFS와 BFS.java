// BOJ 1260번 DFS와 BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] graph;
	static boolean[] visited;
	static Queue<Integer> queue;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점 번호 V 입력
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		// 2차원 배열(인접행렬)을 통해 그래프 구현
		graph = new int[N + 1][N + 1];

		// M개의 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			graph[s][e] = 1;
			graph[e][s] = 1;
			
		}
		
		// visited, sb 초기화 후 dfs 실시
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(V);
		// 결과 출력
		System.out.println(sb);

		// visited, sb 초기화 후 bfs 실시
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		bfs(V);
		// 결과 출력
		System.out.println(sb);
	}

	// dfs
	public static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");

		for (int i = 1; i < graph.length; i++) {
			if (graph[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	// bfs
	public static void bfs(int start) {
		queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		sb.append(start + " ");
		
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for (int i = 1; i < graph.length; i++) {
				if (graph[tmp][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}
	}

}
