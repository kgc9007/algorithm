// BOj 11047번 동전 0

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 동전의 종류의 수 N, 만들어야 하는 가치의 합 K 입력
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// N 종류의 동전의 가치 입력
		// - 오름차순, coin[0] = 1이고 coin[i] = coin[i - 1]의 배수
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		
		// 필요한 동전 개수 count
		// count = 0으로 초기화 후 계산 진행
		int count = 0;
		
		// 큰 가치의 동전으로 먼저 나누고
		// 나머지를 다음 번 가치의 동전으로 다시 나누는 과정 반복
		// 중간에 K원을 만들었다면 종료
		for (int i = N - 1; i >= 0; i--) {
			count += K / coin[i];
			K = K % coin[i];
			
			if (K == 0) {
				break;
			}
		}
		
		// 결과 출력
		System.out.println(count);
	}
}
