// BOJ 1927번 최소 힙

import java.util.Scanner;

public class Main {

	static int[] minHeap;
	static int heapSize;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		minHeap = new int[N + 1];
		heapSize = 0;

		while (N-- > 0) {
			int X = sc.nextInt();
			if (X == 0) {
				System.out.println(pop());
			} else {
				push(X);
			}
		}

	}

	static void push(int num) {
		minHeap[++heapSize] = num;

		int ch = heapSize;
		int p = ch / 2;
		while (p > 0 && minHeap[ch] < minHeap[p]) {
			int tmp = minHeap[p];
			minHeap[p] = minHeap[ch];
			minHeap[ch] = tmp;

			ch = p;
			p = ch / 2;
		}
	}

	static int pop() {
		if (heapSize == 0) {
			return 0;
		}

		int root = minHeap[1];

		minHeap[1] = minHeap[heapSize];
		minHeap[heapSize--] = 0;

		int p = 1;
		int ch = p * 2;
		if (ch + 1 <= heapSize && minHeap[ch + 1] < minHeap[ch]) {
			ch++;
		}

		while (ch <= heapSize && minHeap[ch] < minHeap[p]) {
			int tmp = minHeap[p];
			minHeap[p] = minHeap[ch];
			minHeap[ch] = tmp;

			p = ch;
			ch = p * 2;
			if (ch + 1 <= heapSize && minHeap[ch + 1] < minHeap[ch]) {
				ch++;
			}
		}

		return root;

	}
}
