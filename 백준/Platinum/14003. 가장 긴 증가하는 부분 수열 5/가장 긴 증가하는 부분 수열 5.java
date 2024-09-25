// BOJ 14002번 가장 긴 증가하는 부분 수열 5
// https://www.acmicpc.net/problem/14003

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);

		int[] idx = new int[N];
		idx[0] = 0;

		for (int i = 1; i < N; i++) {
			int num = arr[i];

			int top = list.get(list.size() - 1);
			if (num > top) {
				idx[i] = list.size();
				list.add(num);
			} else {
				int tmp = binarySearch(list, num);
				list.set(tmp, num);
				idx[i] = tmp;
			}
		}

		Stack<Integer> stack = new Stack<>();
		int curr = list.size() - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (idx[i] == curr) {
				stack.add(arr[i]);
				curr--;
			}
			if (curr == -1) {
				break;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		// 결과 출력
		System.out.println(list.size());
		System.out.println(sb);
	}

	// 이분탐색
	public static int binarySearch(List<Integer> list, int num) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (list.get(mid) >= num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}
