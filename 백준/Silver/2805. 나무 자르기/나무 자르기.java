// 2805번 나무 자르기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int height[] = new int[N];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			if (height[i]>max) {
				max = height[i];
			}
		}
		
		System.out.println(func(N, M, height, max));
		
	}
	public static int func (int N, int M, int[] arr, int maxLength) {
		int max = maxLength + 1;
		int min = 0;
		int H = 0;
		
		while (min < max) {
			long sum = 0;
			H = (max + min)/2;
			for (int i=0; i<N; i++) {
				if (arr[i] > H) {
					sum += arr[i] - H;
				}
			}
			if (sum < M) {
				max = H;
			}
			else {
				min = H + 1;
			}
		}
		return (min-1);
	}
	
}