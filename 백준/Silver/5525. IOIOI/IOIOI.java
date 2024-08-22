// BOJ 5525번 IOIOI
// https://www.acmicpc.net/problem/5525

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String S = sc.next();

		int count = 0;
		int result = 0;

		for (int i = 1; i < M - 1; i++) {
			if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				count++;
				
				if (count == N) {
					count--;
					result++;
				}
				i++;
			} else {
				count = 0;
			}
		}

		// 결과 출력
		System.out.println(result);
	}
}
