// BOJ 9375번 패션왕 신해빈
// https://www.acmicpc.net/problem/9375

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();

			HashMap<String, Integer> list = new HashMap<>();

			for (int i = 0; i < N; i++) {
				String item = sc.next();
				String category = sc.next();

				boolean exist = false;
				for (String existCategory : list.keySet()) {
					if (category.equals(existCategory)) {
						int count = list.get(category);
						list.replace(existCategory, count + 1);
						exist = true;
						break;
					}
				}
				
				if (!exist) {
					list.put(category, 1);					
				}
			}
			
			int totalCount = 1;
			for (String existCategory : list.keySet()) {
				totalCount *= list.get(existCategory) + 1;
			}
			
			// 결과 출력
			System.out.println(totalCount - 1);
		}
	}
}
