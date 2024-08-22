// BOJ 2304번 창고 다각형

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] height = new int[1001];
		
		int startIdx = 1000;
		int endIdx = 0;
		int maxHeight = 0;
		int maxHeightIdx = 0;
		
		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			
			height[L] = H;
			
			if (L < startIdx) {
				startIdx = L;
			}
			if (L > endIdx) {
				endIdx = L;
			}
			if (H >= maxHeight) {
				maxHeight = H;
				maxHeightIdx = L;
			}
		}
		
		int count = 0;
		
		int nHeight = 0;
		for (int i = startIdx; i <= maxHeightIdx; i++) {
			if (height[i] > nHeight) {
				nHeight = height[i];
			}
			count += nHeight;
		}
		nHeight = 0;
		for (int i = endIdx; i > maxHeightIdx; i--) {
			if (height[i] > nHeight) {
				nHeight = height[i];
			}
			count += nHeight;
		}
		
		// 결과 출력
		System.out.println(count);
	}
}
