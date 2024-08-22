// BOJ 11286번 절댓값 힙
// https://www.acmicpc.net/problem/11286

import java.util.Scanner;

public class Main {

	static int[] heap;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		heap = new int[N + 1];
		size = 0;

		while (N-- > 0) {
			int x = sc.nextInt();

			if (x == 0) {
				System.out.println(pop());
			} else {
				push(x);
			}
		}
	}

	public static void push(int x) {
		heap[++size] = x;

		int ch = size;
		int p = ch / 2;

		while (p > 0 && (Math.abs(heap[ch]) < Math.abs(heap[p])
				|| (Math.abs(heap[ch]) == Math.abs(heap[p]) && heap[ch] < 0 && heap[p] > 0))) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			ch = p;
			p = ch / 2;
		}

	}

	public static int pop() {
		if (size == 0) {
			return 0;
		}

		int result = heap[1];
		heap[1] = heap[size];
		heap[size--] = 0;

		int p = 1;
		int ch = p * 2;

		if (ch + 1 <= size && (Math.abs(heap[ch]) > Math.abs(heap[ch + 1])
				|| (Math.abs(heap[ch]) == Math.abs(heap[ch + 1]) && heap[ch + 1] < 0 && heap[ch] > 0))) {
			ch += 1;
		}

		while (ch <= size && (Math.abs(heap[ch]) < Math.abs(heap[p])
				|| (Math.abs(heap[ch]) == Math.abs(heap[p]) && heap[ch] < 0 && heap[p] > 0))) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			p = ch;
			ch = p * 2;

			if (ch + 1 <= size && (Math.abs(heap[ch]) > Math.abs(heap[ch + 1])
					|| (Math.abs(heap[ch]) == Math.abs(heap[ch + 1]) && heap[ch + 1] < 0 && heap[ch] > 0))) {
				ch += 1;
			}
		}

		return result;
	}
}
