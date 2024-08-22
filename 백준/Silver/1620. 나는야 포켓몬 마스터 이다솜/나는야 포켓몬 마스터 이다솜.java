// BOJ 1620번 나는야 포켓몬 마스터 이다솜

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도감에 수록되어있는 포켓몬의 개수 N
		int M = sc.nextInt(); // 맞춰야하는 문제의 개수 M

		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();

		int id = 0;
		while (N-- > 0) {
			String name = sc.next();
			id++;

			map.put(name, id);
			list.add(name);
		}

		// 결과 출력
		while (M-- > 0) {
			String search = sc.next();

			// 숫자가 입력되었으면 이름을 출력
			if (search.charAt(0) <= '9') {
				System.out.println(list.get(Integer.parseInt(search) - 1));
			}
			// 이름이 입력되었으면 번호를 출력
			else {
				System.out.println(map.get(search));
			}
		}
	}
}
