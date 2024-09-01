// BOJ 4179번 불!
// https://www.acmicpc.net/problem/4179

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int N; // 미로의 행의 수 N
	static int M; // 미로의 열의 수 M
	static char[][] map; // # : 벽, . : 빈 공간, J : 초기 위치, F : 불이 난 공간

	static int[][] visited1;
	static int[][] visited2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		int minTime = bfs();

		System.out.println(minTime == -1 ? "IMPOSSIBLE" : minTime - 1);

	}

	// bfs
	public static int bfs() {
		Queue<int[]> queue1 = new LinkedList<>();
		Queue<int[]> queue2 = new LinkedList<>();
		visited1 = new int[N][M];
		visited2 = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 'F') {
					queue1.add(new int[] { r, c });
					visited1[r][c] = 1;
				}
				if (map[r][c] == 'J') {
					queue2.add(new int[] { r, c });
					visited2[r][c] = 1;
				}
			}
		}

		while (!queue1.isEmpty()) {
			int[] curr = queue1.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (visited1[nr][nc] != 0 || map[nr][nc] == '#') {
					continue;
				}

				visited1[nr][nc] = visited1[r][c] + 1;
				queue1.add(new int[] { nr, nc });
			}
		}

		while (!queue2.isEmpty()) {
			int[] curr = queue2.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					return visited2[r][c] + 1;
				}

				if (visited2[nr][nc] != 0 || map[nr][nc] == '#') {
					continue;
				}

				if (visited1[nr][nc] != 0 && visited1[nr][nc] <= visited2[r][c] + 1) {
					continue;
				}

				visited2[nr][nc] = visited2[r][c] + 1;
				queue2.add(new int[] { nr, nc });
			}
		}

		return -1;
	}

}
