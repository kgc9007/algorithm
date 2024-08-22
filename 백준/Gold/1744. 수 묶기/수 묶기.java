// BOJ 1744번 수 묶기
// https://www.acmicpc.net/problem/1744

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		List<Integer> minus = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (arr[i] < 0) {
				minus.add(arr[i]);
			} else if (arr[i] > 0) {
				plus.add(arr[i]);
			} else {
				zero.add(arr[i]);
			}
		}

		int sum = 0;

		// 1. 음수가 짝수개인지 홀수개인지 확인
		// 1-1. 음수가 짝수개라면 가장 작은 수부터 차례대로 두 수 씩 묶어서 곱한 후 더한다.
		if (minus.size() % 2 == 0) {
			for (int i = 0; i < minus.size(); i += 2) {
				sum += minus.get(i) * minus.get(i + 1);
			}
		}
		// 1-2. 음수가 홀수개라면
		else {
			for (int i = 0; i < minus.size() - 1; i += 2) {
				sum += minus.get(i) * minus.get(i + 1);
			}
			// 1-2-1. 0이 있으면 더하지 않고
			// 1-2-2. 0이 없다면 마지막 음수(가장 큰 음수)를 더한다.
			if (zero.isEmpty()) {
				sum += minus.get(minus.size() - 1);
			}
		}

		for (int i = plus.size() - 1; i >= 1; i -= 2) {
			int num1 = plus.get(i);
			int num2 = plus.get(i - 1);

			if (num1 > 1 && num2 > 1) {
				sum += num1 * num2;
			} else {
				sum += num1 + num2;
			}
		}

		if (plus.size() % 2 != 0) {
			sum += plus.get(0);
		}

		// 결과 출력
		System.out.println(sum);
	}
}
