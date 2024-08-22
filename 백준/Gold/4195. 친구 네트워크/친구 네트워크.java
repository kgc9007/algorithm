// BOJ 4195번 친구 네트워크
// https://www.acmicpc.net/problem/4195

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> parents;
	static List<Integer> count;
	static Map<String, Integer> idMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			sb = new StringBuilder();

			parents = new ArrayList<Integer>();
			count = new ArrayList<Integer>();
			idMap = new HashMap<String, Integer>();

			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());

				String id1 = st.nextToken();
				String id2 = st.nextToken();

				if (!idMap.containsKey(id1)) {
					idMap.put(id1, parents.size());
					parents.add(parents.size());
					count.add(1);
				}
				if (!idMap.containsKey(id2)) {
					idMap.put(id2, parents.size());
					parents.add(parents.size());
					count.add(1);
				}

				union(idMap.get(id1), idMap.get(id2));

				System.out.println(count.get(find(idMap.get(id1))));
			}
		}

	}

	// find
	public static int find(int x) {
		if (x != parents.get(x)) {
			parents.set(x, find(parents.get(x)));
		}
		return parents.get(x);
	}

	// union
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		if (x > y) {
			parents.set(x, y);
			int sum = count.get(x) + count.get(y);
			count.set(x, sum);
			count.set(y, sum);
		} else {
			parents.set(y, x);
			int sum = count.get(x) + count.get(y);
			count.set(x, sum);
			count.set(y, sum);
		}
	}

}
