// BOJ 17298번 오큰수
// https://www.acmicpc.net/problem/17298

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int[] answer = new int[N];

		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			while (!stack.isEmpty() && stack.peek()[1] < num) {
				int idx = stack.pop()[0];

				answer[idx] = num;
			}
			stack.add(new int[] { i, num });
		}

		for (int i = 0; i < N; i++) {
			if (answer[i] == 0) {
				sb.append("-1 ");
			} else {
				sb.append(answer[i]).append(" ");
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}
