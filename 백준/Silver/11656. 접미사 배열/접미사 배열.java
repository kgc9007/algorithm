// BOJ 11656번 접미사 배열
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 입력
		String S = sc.next();
		String[] arr = new String[S.length()];
		
		// 한글자씩 줄이면서 새로운 문자열 생성 후 배열에 추가
		for (int i=0; i<S.length(); i++) {
			arr[i] = "";
			for (int j=i; j<S.length(); j++) {
				arr[i] += S.charAt(j);
			}
		}
		
		// 정렬 후 결과 출력
		arr = sort(arr);
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	// 문자열 배열 사전순 정렬 (a~z, 길이 짧은순)
	// 버블 정렬 알고리즘 이용
	public static String[] sort(String[] arr) {
		int length = arr.length;
		for (int i=0; i<length-1; i++) {
			for (int j=i+1; j<length; j++) {
				
				// 0번 인덱스부터 시작
				int idx = 0;
				// 비교하려는 두 문자열의 길이를 벗어나기 전까지 한글자씩 비교
				while (idx < arr[i].length() && idx < arr[j].length()) {
					// 뒤의 문자열의 글자가 더 먼저인 경우 문자열 교환 후 break
					if (arr[i].charAt(idx) > arr[j].charAt(idx)) {
						String tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						break;
					} 
					// 앞의 문자열의 글자가 더 먼저인 경우 break -> 다음 문자열로 이동
					else if (arr[i].charAt(idx) < arr[j].charAt(idx)) {
						break;
					}
					// 인덱스 증가
					idx++;
				}
				
				// 모든 문자가 동일하고 글자 수만 다른 경우를 비교
				if (idx == Math.min(arr[i].length(), arr[j].length())) {
					// 짧은 문자열 순으로 정렬
					if (arr[i].length() > arr[j].length()) {
						String tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
		}
		return arr;
	}
	
}
