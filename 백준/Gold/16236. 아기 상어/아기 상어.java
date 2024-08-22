// BOJ 16236번 아기 상어
// https://www.acmicpc.net/problem/15686

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 탐색을 위한 델타배열
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	// 공간에 대한 정보
	static int N; // 공간의 크기 N
	static int[][] map; // 공간의 상태를 저장할 배열

	// 남은 물고기 정보
	static int[] remainFish;

	// 현재 상어의 상태
	static int nowSize = 2; // 현재 상어의 크기
	static int eatCount; // 먹은 물고기의 수 (크기 변경 시 0으로 초기화)

	// 지금까지 지난 시간
	static int time = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 공간의 크기 입력 후 map, remainFish 배열 생성
		N = sc.nextInt();
		map = new int[N][N];
		remainFish = new int[7];

		// 공간의 정보 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();

				// 해당 위치에 물고기가 있다면 남아있는 물고기 정보 추가
				if (map[r][c] > 0 && map[r][c] < 7) {
					remainFish[map[r][c]]++;
				}
			}
		}

		// 먹을 수 있는 물고기가 없을때까지 반복하며 확인
		boolean flag = canEat();
		while (flag) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 9) {
						flag = eat(r, c);
					}
				}
			}
		}

		// 결과 출력
		System.out.println(time);

	}

	// bfs를 이용
	public static boolean eat(int startr, int startc) {
		if (!canEat()) {
			return false;
		}

		// bfs를 위한 큐 생성
		Queue<int[]> queue = new LinkedList<>();

		// 현재 위치에서 해당 위치까지 이동하는데 걸리는 시간을 저장할 배열
		int[][] dist = new int[N][N];
		dist[startr][startc] = 1;

		// 현재 위치 방문 체크 후 큐에 현재 위치 추가
		queue.add(new int[] { startr, startc });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 조건
				// 1. 다음 위치가 경계를 벗어나지 X
				// 2. 아직 방문하지 X
				// 3. 현재 상어의 크기보다 큰 물고기가 위치하지 X
				if (check(nr, nc) && dist[nr][nc] == 0 && map[nr][nc] <= nowSize) {
					dist[nr][nc] = dist[r][c] + 1;

					queue.add(new int[] { nr, nc });
				}
			}

		}

		int minDistance = Integer.MAX_VALUE;
		boolean flag = false;
		int nextr = 0;
		int nextc = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] > 0 && map[r][c] < nowSize && dist[r][c] > 1 && dist[r][c] < minDistance) {
					flag = true;
					minDistance = dist[r][c];
					nextr = r;
					nextc = c;
				}
			}
		}

		if (flag) {
			// 물고기 양 갱신
			remainFish[map[nextr][nextc]]--;

			// 해당 위치로 이동
			map[nextr][nextc] = 9;
			map[startr][startc] = 0;

			// 지금까지 먹은 물고기 수 추가, 크기가 커지는지 확인
			eatCount++;
			if (eatCount == nowSize) {
				nowSize++;
				eatCount = 0;
			}

			// 시간 계산
			time += dist[nextr][nextc] - 1;
			return true;
		}

		return false;
	}

	// 먹을 수 있는 물고기가 남아있는지 확인하는 메소드
	public static boolean canEat() {
		// 현재 상어의 크기보다 작은 물고기가 있는지 확인
		for (int i = 1; i < Math.min(nowSize, remainFish.length); i++) {
			// 있으면 true 반환
			if (remainFish[i] != 0) {
				return true;
			}
		}
		// 끝까지 확인한 후 없으면 false 반환
		return false;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
