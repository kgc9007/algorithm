// BOJ 2589번 보물섬
// https://www.acmicpc.net/problem/2589

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;

	static boolean[][] visited;

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();

			for (int c = 0; c < M; c++) {
				if (str.charAt(c) == 'L') {
					map[r][c] = 1;
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					bfs(new int[] { r, c });
				}
			}
		}

		// 결과 출력
		System.out.println(max);
	}

	public static void bfs(int[] start) {
		visited = new boolean[N][M];

		Queue<int[]> queue = new LinkedList<>();

		int count = 0;
		visited[start[0]][start[1]] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int qsize = queue.size();
			count++;

			while (qsize-- > 0) {
				int[] curr = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						continue;
					}

					if (map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
					}
				}
			}
		}

		max = Math.max(count - 1, max);
	}
}
