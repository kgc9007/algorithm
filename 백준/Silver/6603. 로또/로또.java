// BOJ 6603번 로또
// https://www.acmicpc.net/problem/6603

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] isUsed;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();

			if (N == 0) {
				break;
			}

			arr = new int[N];
			isUsed = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			getCombination(0, 0);
			System.out.println();
		}

	}

	// 조합 구하기 + 결과 출력
	public static void getCombination(int idx, int count) {
		if (count == 6) {
			for (int i = 0; i < N; i++) {
				if (isUsed[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		if (idx == N) {
			return;
		}

		isUsed[idx] = true;
		getCombination(idx + 1, count + 1);

		isUsed[idx] = false;
		getCombination(idx + 1, count);
	}
}
