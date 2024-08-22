// BOJ 15650번 N과 M(2)
// https://www.acmicpc.net/problem/15650

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		result = new int[M];
		getCombination(0, 0);

	}

	// 조합 구하기
	public static void getCombination(int idx, int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			result[count] = arr[i];
			getCombination(i + 1, count + 1);
		}
	}
}
