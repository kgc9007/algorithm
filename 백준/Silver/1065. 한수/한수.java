import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count=0;
		
		for (int i=1; i<=N; i++) {
			if(check(i)) count++;
		}
		System.out.println(count);
	}

	
	
	public static boolean check(int number) {
		if (number<100) return true;
		else if (number==1000) return false;
		else {
			int hun = number/100;
			int ten = (number/10)%10;
			int one = number%10;
			if (hun-ten==ten-one) return true;
			else return false;
		}
	}
}