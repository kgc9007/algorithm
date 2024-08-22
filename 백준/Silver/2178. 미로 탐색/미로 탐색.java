// BOJ 2178번 미로 탐색

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 탐색을 위한 델타배열 생성
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] map;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 미로의 크기 N, M 입력
		N = sc.nextInt();
		M = sc.nextInt();

		// N * M 크기의 미로, 각 칸까지 이동하는데 필요한 횟수를 저장할 배열 length 생성
		map = new int[N][M];

		// 미로의 각 칸의 정보 입력
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}

		// BFS 실시
		BFS(0, 0);

		// 결과 출력
		System.out.println(map[N - 1][M - 1]);

	}

	// BFS
	public static void BFS(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(r);
		queue.add(c);
		while (!queue.isEmpty()) {
			int nowr = queue.poll();
			int nowc = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nextr = nowr + dr[d];
				int nextc = nowc + dc[d];

				// 조건
				// 1. 경계를 벗어나지 X
				// 2. 시작점 X
				// 3. 이동하려는 위치의 값이 1 인 경우(길이 있는 곳일 경우)
				if (check(nextr, nextc) && map[nextr][nextc] == 1) {
					// 다음 탐색을 위해 큐에 이동한 r, c 좌표 추가
					queue.add(nextr);
					queue.add(nextc);

					// 이동한 장소의 값 변경 - 현재 장소 + 1
					map[nextr][nextc] = map[nowr][nowc] + 1;
				}
			}
		}

	}

	// 경계를 벗어났는지와 해당 칸이 시작점인지를 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && !(r == 0 && c == 0);
	}
}
