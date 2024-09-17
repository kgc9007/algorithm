// BOJ 1715번 카드 정렬하기
// https://www.acmicpc.net/problem/1715

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while (N-- > 0) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		while (pq.size() > 1) {
			int num = pq.poll() + pq.poll();
			sum += num;
			pq.add(num);
		}

		// 결과 출력
		System.out.println(sum);
	}
}
