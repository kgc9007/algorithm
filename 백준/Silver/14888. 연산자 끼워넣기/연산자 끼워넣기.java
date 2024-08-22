// BOJ 14888번 연산자 끼워넣기 (SWEA 4008번 숫자 만들기)
// https://www.acmicpc.net/problem/14888

import java.util.Scanner;

public class Main {
	// 숫자의 개수 N
	static int N;
	static int[] num;

	// 연산자 개수를 입력받을 배열 operators
	// 연산자 사용 순서를 입력할 배열 result
	static int[] operators;
	static int[] result;

	// 만들 수 있는 최대, 최소값
	static int max;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		num = new int[N];
		operators = new int[5];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 1; i < 5; i++) {
			operators[i] = sc.nextInt();
		}

		// result 배열 초기화 후 정답(최대, 최소값) 확인
		result = new int[N - 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		getPermutation(0);

		// 결과 출력
		System.out.println(max);
		System.out.println(min);

	}

	// 순열
	public static void getPermutation(int idx) {
		// 마지막 연산자까지 순서를 다 정한 경우(순열이 완성된 경우)
		if (idx == N - 1) {
			// 순서대로 계산 후 결과 확인
			int ans = num[0];

			for (int i = 0; i < N - 1; i++) {
				if (result[i] == 1) {
					ans = ans + num[i + 1];
				} else if (result[i] == 2) {
					ans = ans - num[i + 1];
				} else if (result[i] == 3) {
					ans = ans * num[i + 1];
				} else if (result[i] == 4) {
					ans = ans / num[i + 1];
				}
			}

			// max, min 비교 후 갱신
			max = Math.max(ans, max);
			min = Math.min(ans, min);
			return;
		}

		// 아직 마지막 번호까지 숫자(연산자)를 정하지 못한 경우
		for (int i = 1; i < 5; i++) {
			// 해당 연산자가 남아있다면 그 연산자를 사용하고 다음으로 이동
			if (operators[i] > 0) {
				result[idx] = i;
				operators[i]--;
				getPermutation(idx + 1);
				operators[i]++;
			}
		}
//			if (operators[1] > 0) {
//				result[idx] = 1;
//				operators[1]--;
//				getPermutation(idx + 1);
//				operators[1]++;
//			}
//			if (operators[2] > 0) {
//				result[idx] = 2;
//				operators[2]--;
//				getPermutation(idx + 1);
//				operators[2]++;
//			}
//			if (operators[3] > 0) {
//				result[idx] = 3;
//				operators[3]--;
//				getPermutation(idx + 1);
//				operators[3]++;
//			}
//			if (operators[4] > 0) {
//				result[idx] = 4;
//				operators[4]--;
//				getPermutation(idx + 1);
//				operators[4]++;
//			}

	}
}
