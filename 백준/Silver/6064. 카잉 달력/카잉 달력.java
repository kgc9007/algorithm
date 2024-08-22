// BOJ 6064번 카잉 달력
// https://www.acmicpc.net/problem/6064

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int diff = Math.abs(M - N);

			// x를 먼저 맞춘다.
			int year = x;

			int last = lcm(M, N);

			while (true) {
				// 해가 최소공배수보다 크면 -1 출력
				if (year > last) {
					System.out.println(-1);
					break;
				}
				// year를 N으로 나머지 연산을 하면, y의 값을 알 수 있다.
				else if (((year % N) == 0 ? N : year % N) == y) {
					System.out.println(year);
					break;
				}
				// year는 M만큼 증가하고,
				year += M;
			}

		}
	}

	static int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return gcd(num2, num1 % num2);
	}

	static int lcm(int num1, int num2) {
		return num1 * num2 / gcd(num1, num2);
	}
}
