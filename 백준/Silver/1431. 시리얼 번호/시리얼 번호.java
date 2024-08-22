// BOJ 1431번 시리얼 번호

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 기타의 수 입력
		int N = sc.nextInt();
		
		// 배열 생성 후 기타의 시리얼 번호 입력
		String[] guitar = new String[N];
		for (int i=0; i<N; i++) {
			guitar[i] = sc.next();
		}
		
		// comparator 클래스의 compare 메소드를 이용해서 정렬
		// 1. 문자열의 길이가 짧은 순으로
		// 2. 문자열의 길이가 같으면 문자열의 숫자의 합이 작은 순으로
		// 3. 1, 2번 조건이 모두 같으면 사전순으로 (compareTo메소드 이용)
		Arrays.sort(guitar, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					int sum1 = 0;
					for (int i=0; i<o1.length(); i++) {
						if ('0' <= o1.charAt(i) && o1.charAt(i) <= '9') {
							sum1 += o1.charAt(i) - '0';
						}
					}
					int sum2 = 0;
					for (int i=0; i<o2.length(); i++) {
						if ('0' <= o2.charAt(i) && o2.charAt(i) <= '9') {
							sum2 += o2.charAt(i) - '0';
						}
					}
					if (sum1 == sum2) {
						return o1.compareTo(o2);
					} else {
						return sum1 - sum2;
					}
				} else {
					return o1.length() - o2.length();
				}
			}
		});
		
		// 결과 출력
		for (int i=0; i<N; i++) {
			System.out.println(guitar[i]);
		}
		
	}
}
