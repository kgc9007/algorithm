import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        // N이 5 증가할때마다 0의 개수 ++
        // N이 5의 배수를 지날 때 0의 개수 증가
        // N이 25의 배수를 지날 때 0의 개수 2 증가
        // N이 125의 배수를 지날 때 0의 개수 3 증가
        while (N != 0){
            if (N%125==0){
                result += 3;
            }
            else if (N%25==0) {
                result += 2;
            }
            else if (N%5==0) {
                result ++;
            }
            N--;
        }
        System.out.println(result);
    }
}
