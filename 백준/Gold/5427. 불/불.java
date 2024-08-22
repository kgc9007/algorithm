// BOJ 5427번 불
// https://www.acmicpc.net/problem/5427

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int W;
	static int H;
	static int[][] map;

	static int[] start;

	static boolean[][] visited;

	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int r = 0; r < H; r++) {
				String str = br.readLine();

				for (int c = 0; c < W; c++) {
					if (str.charAt(c) == '.') {
						map[r][c] = 1;
					} else if (str.charAt(c) == '#') {
						map[r][c] = 2;
					} else if (str.charAt(c) == '*') {
						map[r][c] = 3;
					} else {
						map[r][c] = 1;
						start = new int[] { r, c, 0 };
					}
				}
			}

			visited = new boolean[H][W];
			possible = false;

			Queue<int[]> queue = new LinkedList<>();
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (map[r][c] == 3) {
						queue.add(new int[] { r, c, 1 });
					}
				}
			}

			queue.add(start);
			visited[start[0]][start[1]] = true;

			int time = 0;
			while (!queue.isEmpty()) {
				if (possible) {
					break;
				}

				time++;
				int qsize = queue.size();

				while (qsize-- > 0) {
					int[] curr = queue.poll();

					if (curr[2] == 1) {
						for (int d = 0; d < 4; d++) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];

							if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
								continue;
							}

							if (map[nr][nc] == 1) {
								map[nr][nc] = 3;
								queue.add(new int[] { nr, nc, 1 });
							}
						}
					} else {
						if (curr[0] == 0 || curr[0] == H - 1 || curr[1] == 0 || curr[1] == W - 1) {
							possible = true;
							sb.append(time).append('\n');
							break;
						}
						
						for (int d = 0; d < 4; d++) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];

							if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
								continue;
							}

							if (map[nr][nc] == 1 && !visited[nr][nc]) {
								visited[nr][nc] = true;
								queue.add(new int[] { nr, nc, 0 });
							}
						}
					}
				}
			}

			if (!possible) {
				sb.append("IMPOSSIBLE").append('\n');
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}
