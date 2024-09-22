// BOJ 12738번 가장 긴 증가하는 부분 수열 3
// https://www.acmicpc.net/problem/12738

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		list.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int idx = binarySearch(list, num);

				list.set(idx, num);
			}
		}

		// 결과 출력
		System.out.println(list.size());

	}

	// 이분탐색
	public static int binarySearch(List<Integer> list, int num) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (num > list.get(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
