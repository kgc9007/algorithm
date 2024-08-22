// BOJ 15657번 N과 M(9)
// https://www.acmicpc.net/problem/15663

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;

	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		visited = new boolean[N];
		result = new int[M];

		getPermutation(0);
	}

	public static void getPermutation(int idx) {
		if (idx == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}

		int before = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i] && before != arr[i]) {
				result[idx] = arr[i];
				visited[i] = true;
				before = arr[i];
				getPermutation(idx + 1);
				result[idx] = 0;
				visited[i] = false;
			}
		}
	}
}
