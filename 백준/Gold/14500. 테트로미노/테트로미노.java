// BOJ 14500번 테트로미노

import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;

	// 최대값
	static int max;
	
	// 종이에 써 있는 숫자 중 가장 큰 값
	static int maxNum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 종이의 세로 크기 N, 가로 크기 M 입력
		N = sc.nextInt();
		M = sc.nextInt();

		// N * M 크기의 배열 생성 후 값 입력
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();

				maxNum = Math.max(maxNum, map[r][c]);
			}
		}

		// visited, max 초기화
		visited = new boolean[N][M];
		max = 0;

		// 각 칸별로 탐색 실시
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(r, c, 1, map[r][c]);
				visited[r][c] = false;
				
				// ㅗ, ㅓ, ㅏ, ㅜ 모양 탐색
				func1(r, c);
				func2(r, c);
				func3(r, c);
				func4(r, c);
			}
		}

		// 결과 출력
		System.out.println(max);

	}

	// dfs
	// ㅗ, ㅓ, ㅏ, ㅜ 모양을 제외한 나머지 경우 탐색
	public static void dfs(int r, int c, int depth, int sum) {
		// 남은 칸이 모두 최대값이더라도 max를 갱신할 수 없다면 더이상 탐색 X
		if (max - sum > (4 - depth) * maxNum) {
			return;
		}
		
		// 4칸을 탐색한 경우 값을 합계와 최대값을 비교 후 갱신
		// 이후 종료
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		// 사방 탐색 후 다음 칸으로 이동할 수 있으면
		// depth, sum을 증가시키고 해당 칸에서 dfs 실시
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, depth + 1, sum + map[nr][nc]);
				visited[nr][nc] = false;

			}
		}
	}

	// ㅗ, ㅓ, ㅏ, ㅜ 모양 탐색
	// - r, c 기준으로 3방향의 값을 더하는 방식으로 계산
	// 1. 'ㅓ' 모양 : d = 0 ~ 2
	public static void func1(int r, int c) {
		int sum = map[r][c];

		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d % 4];
			int nc = c + dc[d % 4];
			if (check(nr, nc)) {
				sum += map[nr][nc];
			} else {
				return;
			}
		}

		max = Math.max(max, sum);
	}

	// 2. 'ㅜ' 모양 : d = 1 ~ 3
	public static void func2(int r, int c) {
		int sum = map[r][c];

		for (int d = 1; d < 4; d++) {
			int nr = r + dr[d % 4];
			int nc = c + dc[d % 4];
			if (check(nr, nc)) {
				sum += map[nr][nc];
			} else {
				return;
			}
		}

		max = Math.max(max, sum);
	}

	// 3. 'ㅗ' 모양 : d = 2 ~ 3, 0
	public static void func3(int r, int c) {
		int sum = map[r][c];

		for (int d = 2; d < 5; d++) {
			int nr = r + dr[d % 4];
			int nc = c + dc[d % 4];
			if (check(nr, nc)) {
				sum += map[nr][nc];
			} else {
				return;
			}
		}

		max = Math.max(max, sum);
	}

	// 4. 'ㅏ' 모양 : d = 3, 0 ~ 1
	public static void func4(int r, int c) {
		int sum = map[r][c];

		for (int d = 3; d < 6; d++) {
			int nr = r + dr[d % 4];
			int nc = c + dc[d % 4];
			if (check(nr, nc)) {
				sum += map[nr][nc];
			} else {
				return;
			}
		}

		max = Math.max(max, sum);
	}

	// 경계를 벗어나지 않았는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
