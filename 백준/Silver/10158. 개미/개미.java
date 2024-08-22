// BOJ 10158번 개미
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 가로 길이 w와 세로 길이 h 입력
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 현재 위치 p, q 입력
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 계산할 시간 t 입력
		int t = Integer.parseInt(st.nextToken());
		
		// t시간동안 x, y 증가
		x += t;
		y += t;
		
		// 벽에 부딪히면 반대로 오므로
		// x축은 w*2의 주기로 좌표가 반복
		// y축은 h*2의 주기로 좌표가 반복 
		x %= 2*w;
		y %= 2*h;
		
		// 중간을 넘어서는 좌표가 결과로 나오면
		// 반대의 좌표를 반환
		if (x>w) {
			// x = w - (x-w)
			x = 2*w - x;
		}
		if (y>h) {
			// y = h - (y-h)
			y = 2*h - y;
		}
		
		
		// 결과 출력
		System.out.printf("%d %d", x, y);
		
		
	}
}
