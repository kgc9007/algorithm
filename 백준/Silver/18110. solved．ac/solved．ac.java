// BOJ 11810번 solved.ac

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 의견의 수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 난이도 범위인 1 ~ 30에 해당하는 크기의 배열 count 생성
		// 각 난이도별 의견 개수 저장
		int[] count = new int[30];
		
		for (int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine())-1]++;
		}
		
		// 상위 15%, 하위 15% 제외를 위해 minIdx, maxIdx 계산
		int minIdx = (int) Math.round(N*0.15);
		int maxIdx = (int) (N - Math.round(N*0.15));
		
		// 반올림을 위해 sum을 double 형태로 계산
		int idx = 0;
		double sum = 0;
		for (int i=0; i<count.length; i++) {
			while(count[i] != 0) {
				count[i]--;
				idx++;
				if (idx > minIdx && idx <= maxIdx) {
					sum += i+1;
				}
			}
		}
		
		// 결과 계산
		int result = (int) Math.round(sum / (maxIdx-minIdx));
		
		// 결과 출력
		System.out.println(result);
	}
}
