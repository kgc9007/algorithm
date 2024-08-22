// 1654번 랜선 자르기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] list = new int[K];
		int maxLength = 0;
		for (int i=0; i<K; i++) {
			list[i] = Integer.parseInt(br.readLine());
			if (list[i] > maxLength) {
				maxLength = list[i];
			}
		}
		
		System.out.println(func(list, N, maxLength));
		
	}
	public static long func (int[] list, int N, long maxLength) {
		long min = 0;
		long max = maxLength + 1;
		
		while (min < max) {
			long len = (min + max)/2;
			long count = 0;
			for (int i=0; i<list.length; i++) {
				count += (list[i]/len);
			}
			
			if (count < N) {
				max = len;
			}
			else {
				min = len + 1;
			}
			
		}
		
		return (min-1);
	}
	
}
