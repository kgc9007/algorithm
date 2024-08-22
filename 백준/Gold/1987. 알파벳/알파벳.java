// BOJ 1987번 알파벳
// https://www.acmicpc.net/problem/1987

import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static char[][] board;
	static boolean[] visited;

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		board = new char[N][M];
		for (int r = 0; r < N; r++) {
			String str = sc.next();

			for (int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c);
			}
		}

		visited = new boolean[26];
		visited[board[0][0] - 'A'] = true;
		DFS(visited, 0, 0, 1);

		// 결과 출력
		System.out.println(max);

	}

	public static void DFS(boolean[] visited, int r, int c, int count) {
		max = Math.max(max, count);

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
				continue;
			}

			int idx = board[nr][nc] - 'A';

			if (!visited[idx]) {
				visited[idx] = true;
				DFS(visited, nr, nc, count + 1);
				visited[idx] = false;
			}
		}
	}
}
