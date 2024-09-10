// BOJ 10711번 모래성
// https://www.acmicpc.net/problem/10711

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static int H;
	static int W;
	static int[][] map;

	static boolean[][] visited;
	static int[][] count;

	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		for (int r = 0; r < H; r++) {
			String str = br.readLine();
			for (int c = 0; c < W; c++) {
				if (str.charAt(c) == '.') {
					map[r][c] = 0;
				} else {
					map[r][c] = str.charAt(c) - '0';
				}
			}
		}

		visited = new boolean[H][W];

		// 결과 출력
		System.out.println(bfs());
	}

	public static int bfs() {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] == 0 && !visited[r][c]) {
					queue.add(new int[] { r, c });
					visited[r][c] = true;
				}
			}
		}

		int time = 0;
		while (!queue.isEmpty()) {
			int qsize = queue.size();

			while (qsize-- > 0) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];

				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
						continue;
					}

					if (visited[nr][nc]) {
						continue;
					}

					if (map[nr][nc] > 0) {
						map[nr][nc]--;

						if (map[nr][nc] == 0) {
							visited[nr][nc] = true;
							queue.add(new int[] { nr, nc });
						}
						continue;
					}

					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
			}

			time++;
		}

		return time - 1;
	}

}
