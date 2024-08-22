// BOJ 17822번 원판 돌리기
// https://www.acmicpc.net/problem/17822

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] board;

	static List<int[]> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int T = sc.nextInt();

		board = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		list = new ArrayList<>();
		while (T-- > 0) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();

			list.add(new int[] { x, d, k });
		}

		for (int i = 0; i < list.size(); i++) {
			rotate(list.get(i)[0], list.get(i)[1], list.get(i)[2]);
			find();
		}

		// 원판에 남아있는 수의 합 계산
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (board[r][c] != 0) {
					sum += board[r][c];
				}
			}
		}

		// 결과 출력
		System.out.println(sum);

	}

	// 원판 회전 메소드
	public static void rotate(int x, int d, int k) {
		for (int r = x - 1; r < N; r += x) {
			if (d == 0) {
				int[] tmp = Arrays.copyOf(board[r], M);
				for (int c = 0; c < M; c++) {
					board[r][(c + k) % M] = tmp[c];
				}
			} else {
				int[] tmp = Arrays.copyOf(board[r], M);
				for (int c = 0; c < M; c++) {
					board[r][(c + M - k) % M] = tmp[c];
				}
			}
		}
	}

	// 원판의 인접한 칸에 같은 수가 있는지 찾고 있다면 지우는 메소드
	public static void find() {
		boolean[][] tmp = new boolean[N][M];

		for (int c = 0; c < M; c++) {
			if (board[0][c] == board[1][c]) {
				tmp[0][c] = true;
				continue;
			}
			if (board[0][c] == board[0][(c + 1) % M]) {
				tmp[0][c] = true;
				continue;
			}
			if (board[0][c] == board[0][(c + M - 1) % M]) {
				tmp[0][c] = true;
				continue;
			}
		}

		for (int r = 1; r < N - 1; r++) {
			for (int c = 0; c < M; c++) {
				if (board[r][c] == board[r + 1][c]) {
					tmp[r][c] = true;
					continue;
				}
				if (board[r][c] == board[r - 1][c]) {
					tmp[r][c] = true;
					continue;
				}
				if (board[r][c] == board[r][(c + 1) % M]) {
					tmp[r][c] = true;
					continue;
				}
				if (board[r][c] == board[r][(c + M - 1) % M]) {
					tmp[r][c] = true;
					continue;
				}
			}
		}

		for (int c = 0; c < M; c++) {
			if (board[N - 1][c] == board[N - 2][c]) {
				tmp[N - 1][c] = true;
				continue;
			}
			if (board[N - 1][c] == board[N - 1][(c + 1) % M]) {
				tmp[N - 1][c] = true;
				continue;
			}
			if (board[N - 1][c] == board[N - 1][(c + M - 1) % M]) {
				tmp[N - 1][c] = true;
				continue;
			}
		}

		boolean isDeleted = false;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tmp[r][c] && board[r][c] != 0) {
					board[r][c] = 0;
					isDeleted = true;
				}
			}
		}

		if (!isDeleted) {
			update();
		}
	}

	// 원판의 값 변경
	// 원판에 적힌 수의 평균을 구하고 평균보다 큰 수에서 1을 빼고 작은 수에는 1을 더한다.
	public static void update() {
		int sum = 0;
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (board[r][c] != 0) {
					sum += board[r][c];
					count++;
				}
			}
		}

		double avg = (double) sum / count;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (board[r][c] != 0 && board[r][c] > avg) {
					board[r][c]--;
				} else if (board[r][c] != 0 && board[r][c] < avg) {
					board[r][c]++;
				}
			}
		}
	}
}
