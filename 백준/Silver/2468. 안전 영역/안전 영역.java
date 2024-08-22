// BOJ 2468번 안전 영역
// https://www.acmicpc.net/problem/2468

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int maxSafetyArea;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int maxHeight = 0;
		int[][] map = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				maxHeight = Math.max(maxHeight, map[r][c]);
			}
		}

		for (int rain = 0; rain < maxHeight; rain++) {
			int safetyArea = getSafetyArea(map, rain);

			maxSafetyArea = Math.max(maxSafetyArea, safetyArea);
		}

		// 결과 출력
		System.out.println(maxSafetyArea);

	}

	public static int getSafetyArea(int[][] map, int rain) {
		int count = 0;

		int N = map.length;

		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] > rain && !visited[r][c]) {
					count++;

					visited[r][c] = true;
					queue.add(new int[] { r, c });

					while (!queue.isEmpty()) {
						int[] curr = queue.poll();

						for (int d = 0; d < 4; d++) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}

							if (map[nr][nc] > rain && !visited[nr][nc]) {
								visited[nr][nc] = true;
								queue.add(new int[] { nr, nc });
							}
						}
					}

				}
			}
		}

		return count;
	}
}
