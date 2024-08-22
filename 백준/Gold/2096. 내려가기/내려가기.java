// BOJ 2096번 내려가기
// https://www.acmicpc.net/problem/2096

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[N][3];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];
		dpMax[0] = arr[0];
		dpMin[0] = arr[0];

		for (int r = 1; r < N; r++) {
			dpMax[r][0] = Math.max(dpMax[r - 1][0], dpMax[r - 1][1]) + arr[r][0];
			dpMax[r][2] = Math.max(dpMax[r - 1][1], dpMax[r - 1][2]) + arr[r][2];

			dpMax[r][1] = Math.max(dpMax[r - 1][0], dpMax[r - 1][1]);
			dpMax[r][1] = Math.max(dpMax[r][1], dpMax[r - 1][2]);
			dpMax[r][1] += arr[r][1];

			dpMin[r][0] = Math.min(dpMin[r - 1][0], dpMin[r - 1][1]) + arr[r][0];
			dpMin[r][2] = Math.min(dpMin[r - 1][1], dpMin[r - 1][2]) + arr[r][2];

			dpMin[r][1] = Math.min(dpMin[r - 1][0], dpMin[r - 1][1]);
			dpMin[r][1] = Math.min(dpMin[r][1], dpMin[r - 1][2]);
			dpMin[r][1] += arr[r][1];
		}

		for (int c = 0; c < 3; c++) {
			max = Math.max(max, dpMax[N - 1][c]);
			min = Math.min(min, dpMin[N - 1][c]);
		}

		// 결과 출력
		System.out.println(max + " " + min);
	}
}
