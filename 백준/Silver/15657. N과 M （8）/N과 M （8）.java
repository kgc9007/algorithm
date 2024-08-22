// BOJ 15657번 N과 M(8)
// https://www.acmicpc.net/problem/15657

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	static int[] arr;
	static int[] result;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		result = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		getCombination(0, 0);

		// 결과 출력
		System.out.println(sb);

	}

	// 중복조합
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
			getCombination(i, count + 1);
		}
	}
}
