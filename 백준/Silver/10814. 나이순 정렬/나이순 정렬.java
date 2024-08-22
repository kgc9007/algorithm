import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		
		int N = Integer.parseInt(br.readLine());
		String[][] list = new String [N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
		}
		
		Arrays.sort(list, new Comparator<String[]>() {
			@Override
			public int compare (String[] s1, String[] s2) {
				return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);		
		}
		});
		for (int i=0; i<N; i++) {
			System.out.println(list[i][0] + " " + list[i][1]);
		}
	}
}