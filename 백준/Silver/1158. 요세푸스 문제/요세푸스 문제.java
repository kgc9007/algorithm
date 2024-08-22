// BOJ 1158번 요세푸스 문제
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while (q.size() != 1) {
			for (int i=1; i<K; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll());
		
		// 결과 출력
		System.out.printf("<%s>", sb);
	}
}
