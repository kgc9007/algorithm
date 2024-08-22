// BOJ 21608번 상어 초등학교
// https://www.acmicpc.net/problem/21608

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	// 교실의 크기 N
	static int N;
	static int[][] map;

	// 각 학생이 좋아하는 학생의 정보를 저장할 리스트
	// 자리를 정하는 순서대로 입력
	// arr[0] : 해당 순서의 학생 번호
	// arr[1] ~ arr[4] : 해당 학생이 좋아하는 학생의 번호
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			int[] arr = new int[5];
			for (int j = 0; j < 5; j++) {
				arr[j] = sc.nextInt();
			}
			list.add(arr);
		}

		// 자리 배정
		for (int idx = 0; idx < N * N; idx++) {
			getSeat(idx);
		}

		// 점수 계산 후 결과 출력
		System.out.println(getScore());

	}

	// 학생의 자리 배정
	public static void getSeat(int idx) {
		int maxLike = 0;
		int maxBlank = 0;
		int bestR = -1;
		int bestC = -1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0) {
					int countLike = 0;
					int countBlank = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (isNotOut(nr, nc)) {
							if (map[nr][nc] == 0) {
								countBlank++;
								continue;
							}
							for (int i = 1; i < 5; i++) {
								if (map[nr][nc] == list.get(idx)[i]) {
									countLike++;
									break;
								}
							}
						}
					}
					if (countLike > maxLike) {
						maxLike = countLike;
						maxBlank = countBlank;
						bestR = r;
						bestC = c;
					} else if (countLike == maxLike && countBlank > maxBlank) {
						maxBlank = countBlank;
						bestR = r;
						bestC = c;
					} else if (bestR == -1 && bestC == -1) {
						maxLike = countLike;
						maxBlank = countBlank;
						bestR = r;
						bestC = c;
					}
				}
			}
		}
		map[bestR][bestC] = list.get(idx)[0];
	}

	// 점수 계산
	public static int getScore() {
		int score = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int countLike = -1;
				int[] likeList = new int[5];
				for (int i = 0; i < N * N; i++) {
					if (map[r][c] == list.get(i)[0]) {
						likeList = list.get(i);
						break;
					}
				}
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (isNotOut(nr, nc)) {
						for (int i = 1; i < 5; i++) {
							if (map[nr][nc] == likeList[i]) {
								countLike++;
								break;
							}
						}
					}
				}
				if (countLike >= 0) {
					score += (int) Math.pow(10, countLike);
				}
			}
		}
		return score;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean isNotOut(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
