// BOJ 2573번 빙산
// https://www.acmicpc.net/problem/2573

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;

	static boolean[][] visited;

	static boolean allMelted;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		int years = 0;
		allMelted = false;
		while (!overTwo() && !allMelted) {
			years++;
			melt();
			checkAllMelted();
		}

		// 결과 출력
		if (allMelted) {
			System.out.println(0);
		} else {
			System.out.println(years);
		}

	}

	// 바닷물에 닿아있는 빙산을 녹이는 메소드
	public static void melt() {
		int[][] minus = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							continue;
						}

						if (map[nr][nc] != 0) {
							minus[nr][nc]++;
						}
					}
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = Math.max(map[r][c] - minus[r][c], 0);
			}
		}
	}

	// 모든 빙산이 녹았는지 확인하는 메소드
	public static void checkAllMelted() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) {
					return;
				}
			}
		}
		allMelted = true;
		return;
	}

	// 빙산이 두 덩어리 이상인지 확인하는 메소드
	public static boolean overTwo() {
		visited = new boolean[N][M];

		boolean flag = false;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) {
					visited[r][c] = true;
					bfs(new int[] { r, c });

					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && map[r][c] != 0) {
					return true;
				}
			}
		}

		return false;
	}

	// bfs
	// - 빙산이 두 덩어리 이상인지 확인하는 과정에서 사용
	// - 주변에 아직 방문하지 않은 빙산이 있다면 큐에 추가
	public static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (!visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}
}
