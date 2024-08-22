// BOJ 16234번 인구 이동

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 땅의 크기 N
	static int N;
	static int[][] map;

	// 인구 차이가 L명 이상, R명 이하이면 국경선 개방
	static int L;
	static int R;

	// 인구이동이 발생한 일수
	static int days;

	static Queue<int[]> queue;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N, L, R 입력
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		// 각 지역의 인구 수 정보 입력
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 인구이동이 더이상 발생하지 않을때까지 반복
		// isMoved = true로 초기화
		boolean isMoved = true;
		while (isMoved) {
			// 반복 안에 들어오면 isMoved = false로 변경
			isMoved = false;
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c]) {
						visited[r][c] = true;
						boolean flag = getUnion(new int[] { r, c });

						if (flag) {
							isMoved = true;
						}
					}
				}
			}
			if (isMoved) {
				days++;
			}
		}

		// 결과 출력
		System.out.println(days);

	}

	// 연합 확인
	// 인구이동이 발생하지 않으면 false 반환
	public static boolean getUnion(int[] position) {
		List<int[]> list = new ArrayList<>();
		list.add(position);

		int sum = map[position[0]][position[1]];

		queue = new LinkedList<>();
		queue.add(position);

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 다음 조건이 성립하면 국경을 열고 인구수 합에 추가
				// 1. 탐색할 구역이 경계를 벗어나지 않고
				// 2. 아직 연합에 추가되지 않았고
				// 3. 인구수 차이가 국경을 열 수 있는 범위 안에 있으면
				if (check(nr, nc) && !visited[nr][nc] && canOpen(r, c, nr, nc)) {
					visited[nr][nc] = true;

					list.add(new int[] { nr, nc });

					sum += map[nr][nc];

					queue.add(new int[] { nr, nc });
				}
			}
		}

		// 인구 이동 실시
		if (list.size() != 1) {
			move(sum / list.size(), list);
		}

		return list.size() != 1;
	}

	// 인구 이동 메소드
	// 서로 연합인 지역의 인구수를 모두 동일하게 변경
	public static void move(int newPopulation, List<int[]> unionList) {
		for (int i = 0; i < unionList.size(); i++) {
			int r = unionList.get(i)[0];
			int c = unionList.get(i)[1];
			
			map[r][c] = newPopulation;
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	// 인접 구역과의 인구 차이가 L 이상, R 이하인지 확인하는 메소드
	public static boolean canOpen(int r, int c, int nr, int nc) {
		int diff = Math.abs(map[r][c] - map[nr][nc]);
		return diff >= L && diff <= R;
	}
}
