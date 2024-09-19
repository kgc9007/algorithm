// BOJ 11967번 불켜기
// https://www.acmicpc.net/problem/11967

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static boolean[][] map;
	static boolean[][] visited;

	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1];

		List<int[]>[][] adj = new List[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				adj[r][c] = new ArrayList<int[]>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[x][y].add(new int[] { a, b });
		}

		visited = new boolean[N + 1][N + 1];
		Queue<int[]> queue = new LinkedList<>();

		visited[1][1] = true;
		map[1][1] = true;
		queue.add(new int[] { 1, 1 });

		int count = 1;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			if (!adj[r][c].isEmpty()) {
				visited = new boolean[N + 1][N + 1];
				visited[r][c] = true;

				for (int[] arr : adj[r][c]) {
					if (!map[arr[0]][arr[1]]) {
						map[arr[0]][arr[1]] = true;
						count++;
					}
				}

				adj[r][c].clear();
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 1 || nr > N || nc < 1 || nc > N) {
					continue;
				}

				if (!map[nr][nc] || visited[nr][nc]) {
					continue;
				}

				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}

		// 결과 출력
		System.out.println(count);

	}
}
