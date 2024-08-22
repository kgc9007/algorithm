// BOJ 17219번 비밀번호 찾기
// https://www.acmicpc.net/problem/17219

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();

		// 사이트 주소, 비밀번호를 저장할 해시맵 생성
		// key : 사이트 주소
		// value : 비밀번호
		HashMap<String, String> list = new HashMap<>();

		while (N-- > 0) {
			list.put(sc.next(), sc.next());
		}

		while (M-- > 0) {
			String address = sc.next();
			
			sb.append(list.get(address)).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}
}
