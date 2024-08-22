import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//각 숫자 횟수 counting
		int[] counting = new int[10];
		while (N!=0) {
			counting[N%10]++;
			N /= 10;
		}
		//누적합으로 변환
		for (int i=1; i<counting.length; i++) {
			counting[i] += counting[i-1];
		}
		//누접합을 이용하여 내림차순으로 StringBuilder에 추가
		for (int i=9; i>=0; i--) {
			if (i!=0) {
				while(counting[i]>counting[i-1]) {
				sb.append(i);
				counting[i]--;
				}
			}
			else {
				while(counting[i]!=0) {
					sb.append(i);
					counting[i]--;
				}
			}
		}
		System.out.println(sb);
	}
}