// BOJ 12851번 숨바꼭질 2
// https://www.acmicpc.net/problem/12851

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int min = Integer.MAX_VALUE;
		int count = 0;

		int[] visited = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (curr == K) {
				min = visited[curr];
				count++;
			}

			if (curr - 1 >= 0 && (visited[curr - 1] == 0 || visited[curr - 1] == visited[curr] + 1)) {
				visited[curr - 1] = visited[curr] + 1;
				queue.add(curr - 1);
			}

			if (curr + 1 <= 100000 && (visited[curr + 1] == 0 || visited[curr + 1] == visited[curr] + 1)) {
				visited[curr + 1] = visited[curr] + 1;
				queue.add(curr + 1);
			}

			if (curr * 2 >= 0 && curr * 2 <= 100000
					&& (visited[curr * 2] == 0 || visited[curr * 2] == visited[curr] + 1)) {
				visited[curr * 2] = visited[curr] + 1;
				queue.add(curr * 2);
			}

		}

		min--;

		// 결과 출력
		System.out.println(min);
		System.out.println(count);
	}
}
