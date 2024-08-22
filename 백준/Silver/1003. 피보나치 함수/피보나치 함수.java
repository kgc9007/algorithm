// BOJ 1003 피보나치 함수

import java.util.Scanner;

public class Main {

	public static Integer[][] count = new Integer[41][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		count[0][0] = 1;
		count[0][1] = 0;
		count[1][0] = 0;
		count[1][1] = 1;

		while (T-- > 0) {
			int N = sc.nextInt();
			fibo(N);
			System.out.println(count[N][0] + " " + count[N][1]);
		}
	}

	public static Integer[] fibo(int N) {
		if (count[N][0] == null || count[N][1] == null) {
			count[N][0] = fibo(N-1)[0] + fibo(N-2)[0];
			count[N][1] = fibo(N-1)[1] + fibo(N-2)[1];
		}
		return count[N];
	}
}
