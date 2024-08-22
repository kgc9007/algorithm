// BOJ 11723번 집합
// https://www.acmicpc.net/problem/11723

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S = 0;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
			case "add":
				add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				check(Integer.parseInt(st.nextToken()));
				break;
			case "toggle":
				toggle(Integer.parseInt(st.nextToken()));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			default:
				break;
			}
		}
		
		// 결과 출력
		System.out.println(sb);
	}

	public static void add(int X) {
		S = S | (1 << X);
	}

	public static void remove(int X) {
		S = S & ~(1 << X);
	}

	public static void check(int X) {
		if ((S & (1 << X)) == (1 << X)) {
			sb.append(1).append("\n");
			return;
		}
		sb.append(0).append("\n");
	}

	public static void toggle(int X) {
		S = S ^ (1 << X);
	}

	public static void all() {
		for (int i = 1; i <= 20; i++) {
			S = S | 1 << i;
		}
	}

	public static void empty() {
		S = 0;
	}
}
