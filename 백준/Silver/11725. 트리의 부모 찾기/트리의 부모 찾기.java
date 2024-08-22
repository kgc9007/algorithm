// BOJ 11725번 트리의 부모 찾기

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;

	static List<Integer>[] list;
	static boolean[] visited;

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			list[s].add(e);
			list[e].add(s);
		}

		visited = new boolean[N + 1];
		p = new int[N + 1];

		dfs(1);

		// 결과 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		}
	}

	// dfs
	public static void dfs(int s) {
		visited[s] = true;

		for (int i = 0; i < list[s].size(); i++) {
			if (!visited[list[s].get(i)]) {
				p[list[s].get(i)] = s;
				dfs(list[s].get(i));
			}
		}
	}
}