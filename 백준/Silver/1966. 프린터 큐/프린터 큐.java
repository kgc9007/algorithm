// BOJ 1966번 프린터 큐

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			Queue<Integer> priority = new LinkedList<>();
			Queue<Integer> index = new LinkedList<>();
			
			for (int i=0; i<N; i++) {
				priority.add(sc.nextInt());
				index.add(i);
			}
			
			int count = 0;
			int queueSize = N;
			while (!priority.isEmpty()) {
				int maxPriority = 0;
				for (int i=0; i<queueSize; i++) {
					int num = priority.poll();
					if (num > maxPriority) {
						maxPriority = num;
					}
					priority.add(num);
				}
				if (priority.peek() == maxPriority) {
					count++;
					priority.poll();
					int num = index.poll();
					queueSize--;
					if (num == M) {
						break;
					}
				} else if (priority.peek() < maxPriority) {
					priority.add(priority.poll());
					index.add(index.poll());
				}
			}
			
			// 결과 출력
			System.out.println(count);
		}
	}
}
