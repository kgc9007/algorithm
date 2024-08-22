// BOJ 1697번 숨바꼭질

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int K;
	static int[] timesToPoint = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수빈이의 현재 위치 N, 동생의 현재 위치 K 입력
		N = sc.nextInt();
		K = sc.nextInt();

		// 탐색
		if (N != K) {
			bfs(N);			
		}
		
		// 결과 출력
		System.out.println(timesToPoint[K]);
	}

	// bfs
	public static void bfs(int N) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(N);

		while (!queue.isEmpty()) {
			int nowPoint = queue.poll();

			// 1. 걸어서 이동 - X-1, X+1로 이동
			// 1-1. X-1로 이동
			if (nowPoint - 1 >= 0 && timesToPoint[nowPoint - 1] == 0) {
				timesToPoint[nowPoint - 1] = timesToPoint[nowPoint] + 1;
				if (nowPoint - 1 == K) {
					return;
				}
				queue.add(nowPoint - 1);
			}
			// 1-2. X+1로 이동
			if (nowPoint + 1 <= 100000 && timesToPoint[nowPoint + 1] == 0) {
				timesToPoint[nowPoint + 1] = timesToPoint[nowPoint] + 1;
				if (nowPoint + 1 == K) {
					return;
				}
				queue.add(nowPoint + 1);
			}
			// 2. 순간이동 - 2*X로 이동
			if (2 * nowPoint <= 100000 && timesToPoint[2 * nowPoint] == 0) {
				timesToPoint[2 * nowPoint] = timesToPoint[nowPoint] + 1;
				if (2 * nowPoint == K) {
					return;
				}
				queue.add(2 * nowPoint);
			}

		}
	}
}
