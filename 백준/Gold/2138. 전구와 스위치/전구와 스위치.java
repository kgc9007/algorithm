import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String curr = br.readLine();
		String target = br.readLine();

		boolean[] currArr1 = new boolean[N + 1];
		boolean[] currArr2 = new boolean[N + 1];
		boolean[] targetArr = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			if (curr.charAt(i) == '1') {
				currArr1[i] = true;
			}
			if (target.charAt(i) == '1') {
				targetArr[i] = true;
			}
		}
		currArr2 = Arrays.copyOf(currArr1, N + 1);

		int count1 = 0;
		for (int i = 1; i < N; i++) {
			if (currArr1[i - 1] != targetArr[i - 1]) {
				count1++;
				currArr1[i - 1] = !currArr1[i - 1];
				currArr1[i] = !currArr1[i];
				currArr1[i + 1] = !currArr1[i + 1];
			}
		}

		if (currArr1[N - 1] != targetArr[N - 1]) {
			count1 = Integer.MAX_VALUE;
		}

		int count2 = 1;
		currArr2[0] = !currArr2[0];
		currArr2[1] = !currArr2[1];
		for (int i = 1; i < N; i++) {
			if (currArr2[i - 1] != targetArr[i - 1]) {
				count2++;
				currArr2[i - 1] = !currArr2[i - 1];
				currArr2[i] = !currArr2[i];
				currArr2[i + 1] = !currArr2[i + 1];
			}
		}

		if (currArr2[N - 1] != targetArr[N - 1]) {
			count2 = Integer.MAX_VALUE;
		}

		if (count1 == Integer.MAX_VALUE && count2 == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(count1, count2));
		}
	}
}
