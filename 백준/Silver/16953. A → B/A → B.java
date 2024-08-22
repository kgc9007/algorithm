// BOJ 16953번 A -> B
// https://www.acmicpc.net/problem/16953

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static long A;
	static long B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();

		int result = bfs();

		// 결과 출력
		System.out.println(result);
	}

	// bfs
	public static int bfs() {
		Queue<Long> queue = new LinkedList<>();
		queue.add(A);
		int cnt = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				long tmp = queue.poll();
				if (tmp == B)
					return cnt + 1;

				if (tmp * 2 <= B)
					queue.add(tmp * 2);
				if (tmp * 10 + 1 <= B)
					queue.add(tmp * 10 + 1);
			}
			cnt++;
		}
		return -1;
	}
}
