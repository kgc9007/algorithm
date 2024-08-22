// BOJ 15654번 N과 M(5)
// https://www.acmicpc.net/problem/15654

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
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			result[idx] = arr[i];
			visited[i] = true;
			getPermutation(idx + 1);
			visited[i] = false;
		}
	}
}
