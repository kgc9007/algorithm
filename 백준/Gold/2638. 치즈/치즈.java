// BOJ 2638번 치즈
// https://www.acmicpc.net/problem/2638

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 판의 크기 N, M
	// 판의 정보를 입력할 배열 map
	static int N;
	static int M;
	static int[][] map;

	// 공기가 실내온도인지를 저장할 배열
	static boolean[][] activated;

	// bfs를 위한 방문 배열
	static boolean[][] visited;

	// 모든 치즈가 녹아서 없어지는데 걸리는 시간 lastTime
	static int lastTime = -1;

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
		
		boolean isAllMelted = false;
		while (!isAllMelted) {
			lastTime++;
			visited = new boolean[N][M];
			if (bfs() == 0) {
				isAllMelted = true;
			}
		}
		
		// 결과 출력
		System.out.println(lastTime);
	}

	// bfs
	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;

		activated = new boolean[N][M];
		activated[0][0] = true;
		dfs(0, 0);

		visited[0][0] = true;
		queue.add(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && map[nr][nc] == 0 && activated[nr][nc] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
				
				if (check(nr, nc) && map[nr][nc] == 1 && isContacted(nr, nc)) {
					visited[nr][nc] = true;
					map[nr][nc] = 0;
					count++;
				}
			}
		}
		return count;
	}

	// dfs
	public static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && map[nr][nc] == 0 && !activated[nr][nc]) {
				activated[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

	// 두 변 이상이 실내온도의 공기와 접촉하고 있는지 확인하는 메소드
	public static boolean isContacted(int r, int c) {
		int count = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && map[nr][nc] == 0 && activated[nr][nc]) {
				count++;
			}
		}

		if (count >= 2) {
			return true;
		}

		return false;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
