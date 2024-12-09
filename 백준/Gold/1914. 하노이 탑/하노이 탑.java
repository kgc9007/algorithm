// BOJ 1914번 하노이 탑
// https://www.acmicpc.net/problem/1914

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(getHanoiNumber(N));

		if (N <= 20) {
			getHanoi(N, 1, 2, 3);
		}

	}

	public static BigInteger getHanoiNumber(int N) {
		return new BigInteger("2").pow(N).subtract(new BigInteger("1"));
	}

	public static void getHanoi(int N, int from, int mid, int to) {
		if (N == 0) {
			return;
		}
		getHanoi(N - 1, from, to, mid);
		System.out.println(from + " " + to);
		getHanoi(N - 1, mid, from, to);
	}
}
