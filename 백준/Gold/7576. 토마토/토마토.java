// BOJ 7576번 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int N;
	static int M;
	static int[][] box;
	static boolean[][] visited;

	// 토마토가 모두 익을 수 있는지 여부를 저장할 변수 possible
	// 토마토가 모두 익는 데 걸리는 최소 날짜를 저장할 변수 min
	static boolean possible;
	static int min;

	// bfs를 위한 큐
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 상자의 가로 칸 수 M, 세로 칸 수 N 입력
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// N * M 크기의 배열 box, visited 생성
		box = new int[N][M];
		visited = new boolean[N][M];

		// 배열 box에 값 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 배열을 순회하면서 해당 칸의 토마토가 이미 익어있다면(값이 1이라면) 큐에 추가
		// 추가 이후 visited[r][c]를 true로 변경
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 1) {
					queue.add(new int[] { r, c });
					visited[r][c] = true;
				}
			}
		}

		// bfs 실시
		bfs();

		// possible, min 초기화 후 결과 확인
		possible = true;
		min = Integer.MIN_VALUE;
		getMin();

		// 결과 출력
		if (possible) {
			System.out.println(min - 1);
		} else {
			System.out.println(-1);
		}

	}

	// bfs
	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1];

			// 주변 탐색(상, 하, 좌, 우)
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 1. 경계를 벗어나지 않고 - check(nr, nc)
				// 2. 아직 방문하지 않고 - !visited[nr][nc]
				// 3. 토마토가 들어있는 칸이라면 - box[nr][nc] != -1
				// -> visited 체크, 해당 칸의 값 변경 후 큐에 추가
				if (check(nr, nc) && !visited[nr][nc] && box[nr][nc] != -1) {
					visited[nr][nc] = true;
					box[nr][nc] = box[r][c] + 1;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

	// 결과 확인 메소드
	public static void getMin() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) {
					possible = false;
					return;
				}
				if (box[r][c] > 0) {
					min = Math.max(min, box[r][c]);
				}
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
