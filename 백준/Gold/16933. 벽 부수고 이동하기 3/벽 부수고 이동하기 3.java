// BOJ 16933번 벽 부수고 이동하기 3
// https://www.acmicpc.net/problem/16933

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS를 위한 클래스
class Point {
	int row;
	int col;
	int breakCount;
	int dist;
	boolean daytime;

	Point(int row, int col, int breakCount, int dist, boolean dayTime) {
		this.row = row;
		this.col = col;
		this.breakCount = breakCount;
		this.dist = dist;
		this.daytime = dayTime;
	}
}

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int N; // 행의 수 N
	static int M; // 열의 수 M
	static int K; // 벽을 부술 수 있는 횟수 K
	static int[][] map;

	static int[][][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}

		// 방문 배열 초기화
		visited = new int[N][M][K + 1];

		// BFS
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0, 1, true));
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			Point curr = queue.poll();

			int r = curr.row;
			int c = curr.col;
			int breakCount = curr.breakCount;
			int dist = curr.dist;
			boolean isDaytime = curr.daytime;

			if (r == N - 1 && c == M - 1) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 다음 칸이 경계를 벗어난 경우 제외
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				// 다음 칸이 빈 칸이고 아직 방문한 적이 없는 경우
				// 다음 칸으로 이동, 큐에 추가 -> 거리 +1, 낮 - 밤 변경
				if (map[nr][nc] == 0 && visited[nr][nc][breakCount] == 0) {
					visited[nr][nc][breakCount] = dist + 1;
					queue.add(new Point(nr, nc, breakCount, dist + 1, !isDaytime));
					continue;
				}

				// 다음 칸이 벽인 경우
				// - 아직 벽을 부술 수 있는 횟수가 남아있고 벽을 부수고 다음 칸을 방문한 적이 없고 낮인 경우
				// 다음 칸으로 이동, 큐에 추가 -> 거리 +1, 벽을 부순 횟수 + 1, 낮 - 밤 변경
				if (map[nr][nc] == 1 && breakCount < K && visited[nr][nc][breakCount + 1] == 0 && isDaytime) {
					visited[nr][nc][breakCount + 1] = dist + 1;
					queue.add(new Point(nr, nc, breakCount + 1, dist + 1, !isDaytime));
				}
			}

			// 밤인 경우 + 현재 위치에 방문한게 처음인 경우 -> 제자리에서 이동 거리 + 1
			if (breakCount < K && !isDaytime && dist <= visited[r][c][breakCount]) {
				queue.add(new Point(r, c, breakCount, dist + 1, !isDaytime));
			}
		}

		// 최소 이동거리 확인
		for (int i = 0; i <= K; i++) {
			if (visited[N - 1][M - 1][i] != 0) {
				min = Math.min(visited[N - 1][M - 1][i], min);
			}
		}

		// 결과 출력
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}