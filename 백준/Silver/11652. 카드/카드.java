// BOJ 11652번 카드

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		// 카드에 적힌 수 Long (-2^62 ~ 2^62) / 해당 숫자 카드의 개수 Integer (1~100,000)
		Map<Long, Integer> map = new HashMap<>();
		
		// 한 장 이상 가지고 있는 숫자를 List에 저장
		List<Long> list = new ArrayList<>();

		// N 장의 카드를 입력
		// 이미 map에 저장된 카드면 카드의 개수++
		// 아직 map에 저장되지 않은 카드이면 새로 입력
		for (int i = 0; i < N; i++) {
			long num = sc.nextLong();
			if (map.containsKey(num)) {
				int count = map.get(num);
				count++;
				map.put(num, count);
			} else {
				map.put(num, 1);
				list.add(num);
			}
		}
		
		// list 정렬
		Collections.sort(list);
		
		// 최대 빈도수 maxCnt = 0으로 초기화
		// 결과값 Long.Max_VALUE로 초기화(같은 빈도수이면 작은 값으로 설정!)
		int maxCnt = 0;
		long result = Long.MAX_VALUE;
		// 리스트의 모든 값을 순차적으로 비교 -> 모든 map의 키 값 별로 비교 가능
		for (int i = 0; i < list.size(); i++) {
			long num = list.get(i);
			if (map.get(num) > maxCnt) {
				result = num;
				maxCnt = map.get(num);
			}
		}
		
		// 결과 출력
		System.out.println(result);

	}

}
