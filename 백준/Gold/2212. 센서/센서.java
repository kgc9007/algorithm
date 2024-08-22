// BOJ 2212번 센서
// https://www.acmicpc.net/problem/2212

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] sensors = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensors);

		Integer[] diff = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = sensors[i + 1] - sensors[i];
		}

		int sum = 0;
		Arrays.sort(diff);
		for (int i = 0; i < N - K; i++) {
			sum += diff[i];
		}

		System.out.println(sum);

	}
}
