import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // N >= 3

        // 3, 5 -> 1
        // 4, 7 -> -1
        // 6, 8, 10 -> 2
        // 9, 11, 13, 15 -> 3
        // 12, 14 -> 4

        // 16 -> 4
        // 17 -> 5

        int s = N / 5;
        int r = N % 5;

        int result = s;

        if (N==4 || N==7) {
            result = -1;
        } else {
            switch (r) {
                case 1: result += 1;
                    break;
                case 2: result += 2;
                    break;
                case 3: result += 1;
                    break;
                case 4: result += 2;
            }
        }

        System.out.println(result);

    }
}
