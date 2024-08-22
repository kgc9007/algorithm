// BOJ 14719번 빗물
// https://www.acmicpc.net/problem/14719

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();

		int[] heights = new int[W];
		int maxHeight = 0;
		int maxHeightIdx = 0;
		for (int i = 0; i < W; i++) {
			heights[i] = sc.nextInt();
			if (heights[i] > maxHeight) {
				maxHeight = heights[i];
				maxHeightIdx = i;
			}
		}

		int sum = 0;

		int nHeight = 0;
		for (int i = 0; i < maxHeightIdx; i++) {
			if (nHeight > heights[i]) {
				sum += nHeight - heights[i];
			} else {
				nHeight = heights[i];
			}
		}

		nHeight = 0;
		for (int i = W - 1; i > maxHeightIdx; i--) {
			if (nHeight > heights[i]) {
				sum += nHeight - heights[i];
			} else {
				nHeight = heights[i];
			}
		}

		// 결과 출력
		System.out.println(sum);
	}
}
