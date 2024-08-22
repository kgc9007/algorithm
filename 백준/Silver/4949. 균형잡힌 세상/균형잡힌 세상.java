// BOJ 4949번 균형잡힌 세상

// 스택 구현 O, 패키지 사용 X

import java.util.Scanner;

public class Main {
	
	public static char[] stack;
	public static int top;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// 문자열 1줄 입력
			String str = new String(sc.nextLine());
			
			// (, ), [, ]를 저장할 stack 생성
			stack = new char[str.length()];
			top = -1;
			
			// 결과를 저장할 변수 result 선언
			boolean result;
			
			// . 이 입력된 경우 종료/아니면 solve 결과를 result로 저장
			if (str.equals(".")) {
				break;
			} else { 
				result = solve(str);
			}

			// 결과 출력
			if (result) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}

	}

	public static boolean solve(String str) {
		// 문자열을 한글자씩 전체 탐색
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			// i 번째 글자가 ( 나 [ 이면 stack에 추가
			
			// i 번째 글자가 )이면
			// 스택의 최상단에 ( 가 있는지 확인 후 있으면 pop 실시, 없으면 false 반환
			// i 번째 글자가 ]이면
			// 스택의 최상단에 [ 가 있는지 확인 후 있으면 pop 실시, 없으면 false 반환
			if (ch == '(' || ch == '[') {
				push(ch);
			} else if (ch == ')') {
				if (!isEmpty() && peek() == '(') {
					pop();
				} else {
					return false;
				}
			} else if (ch == ']') {
				if (!isEmpty() && peek() == '[') {
					pop();
				} else {
					return false;
				}
			}
		}
		
		// 끝까지 확인한 후 스택에 남아있는 원소가 없으면 true 반환
		// 남아있는 원소가 있으면 false 반환
		if (isEmpty()) {
			return true;
		}
		return false;
	}

	// 스택 구현
	public static void push(char ch) {
		stack[++top] = ch;
	}
	
	public static char pop() {
		return stack[top--];
	}
	
	public static char peek() {
		return stack[top];
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
}
