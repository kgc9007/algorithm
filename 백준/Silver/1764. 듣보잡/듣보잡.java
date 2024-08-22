// BOJ 1764번
// https://www.acmicpc.net/problem/1764

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		String[] arr = new String[N + M];
		for (int i = 0; i < N + M; i++) {
			arr[i] = sc.next();
		}

		Arrays.sort(arr);

		List<String> result = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals(arr[i + 1])) {
				result.add(arr[i]);
				i++;
			}
		}
		
		// 결과 출력
		System.out.println(result.size());
		for (int i = 0 ; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
}
