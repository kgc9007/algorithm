// BOJ 1759번 암호 만들기
// https://www.acmicpc.net/problem/1759

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	// 암호의 길이 L
	// 암호에 들어갈 수 있는 문자의 종류 C
	static int L;
	static int C;
	
	// 암호에 들어갈 수 있는 문자들을 저장할 배열 letter
	// 해당 문자가 사용되는지를 표시할 배열 isUsed
	static char[] letter;
	static boolean[] isUsed;
	
	// 자음 모음 구분을 위해 모음 배열 생성
	static char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// L, C 입력
		L = sc.nextInt();
		C = sc.nextInt();

		// 배열 생성
		letter = new char[C];
		isUsed = new boolean[C];

		// 정보 입력
		for (int i = 0; i < C; i++) {
			letter[i] = sc.next().charAt(0);
		}

		/*
		 * [조건] 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고
		 * 추측된다. 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다. --> 정렬 필요
		 */
		Arrays.sort(letter);
		
		// 조합!
		getCombination(0, 0);

	}

	// 조합!
	// - idx번째 문자까지 확인
	// - count개의 문자 사용
	public static void getCombination(int idx, int count) {
		// L개의 문자를 모두 고른 경우
		// 결과를 문자열로 변환 후 모음, 자음 개수 확인
		if (count == L) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C; i++) {
				if (isUsed[i]) {
					sb.append(letter[i]);
				}
			}

			boolean canUse = false;
			int count1 = 0; // 모음 개수
			int count2 = 0; // 자음 개수
			for (int i = 0; i < L; i++) {
				boolean isVowel = false;
				for (int j = 0; j < 5; j++) {
					if (sb.charAt(i) == vowels[j]) {
						count1++;
						isVowel = true;
						break;
					}
				}
				if (!isVowel) {
					count2++;					
				}
				
				// 자음 모음 개수가 조건을 만족하면 canUse 변환 후 종료
				if (count1 > 0 && count2 > 1) {
					canUse = true;
					break;
				}
			}
			
			// 해당 암호를 사용 가능하면 출력
			if (canUse) {
				System.out.println(sb);
			}

			return;
		}
		
		// 마지막 문자까지 사용 여부를 결정했다면 종료
		if (idx == C) {
			return;
		}

		// 해당 문자 사용 O
		isUsed[idx] = true;
		getCombination(idx + 1, count + 1);

		// 해당 문자 사용 X
		isUsed[idx] = false;
		getCombination(idx + 1, count);
	}
}
