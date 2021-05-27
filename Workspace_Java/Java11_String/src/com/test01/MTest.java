package com.test01;

public class MTest {

	private static String str = "The String class represents character strings.";

	public static void main(String[] args) {
		String s = "Hello";
		System.out.println(s + 1 + 2); // s("Hello")가 문자열이기 때문에 1이 문자열로 바뀌고 결국 "Hello"+1 = Hello1 + 2가 되는 것이다.
		System.out.println(1 + 2 + s); // 문자값 1+2를 먼저 계산하고 다음에 "Hello"를 받는다.
		System.out.println(s);

		String h = "Hello";
		System.out.println(h);

		System.out.println(s == h); // String은 참조타입이기 때문에 s와 h는 같은 주소값을 사용한다.

		String newS = new String("Hello");
		System.out.println(newS);

		System.out.println(s == newS); // new String을 명령했기 때문에 새로운 String을 만들었다.
		// s = 1 + 2 + s;
		// System.out.println(s); // 스트링 풀에 이미 3s가 있으면 s = 1 + 2 + s일 경우 스트링 풀에 있는 값을
		// 생성하는 게 아닌 그냥 가져오는 것이다.

		// String h = "Hello"; // h가 새로운 값을 생성햐는 게 아닌 s를 가져오는 것이다.
		// System.out.println(h); // h를 생성하는 것이 아닌 String s = "Hello"값을 가져오는 것이다.

		// String newS = new String("Hello");
		// System.out.println(newS); // 이 경우는 s의 "Hello"를 가져오는 것이 아닌 newS를 새로 만드는 것이다.
		// 즉, 문자열은 절대 변하지 않는다.

		System.out.println("---------------------");

		// 1. str의 길이
		test01();

		// 2. str 전체 대문자
		test02();

		// 3. str 전체 소문자
		test03();

		// 4. str에서 첫번째로 나오는 c의 위치(인덱스)
		test04();

		// 5. class 단어를 찾아서 java로 바꿔서
		test05();

		// 6. character 단어를 찾아서 대문자로 변환 후, 전체 출력
		test06();

		// 7. str을 char[]로 출력하되, 'c'만 출력하자.
		// 그리고, c의 갯수를 출력
		test07();

		// 8. str을 char[]로 출력하되, 대문자만 출력하자.
		// 그리고, 대문자의 갯수를 출력
		test08();

		// 9. str 사이의 공백 제거 후 출력
		test09();

		// 10. 전체를 역순으로 출력
		test10();

	}

	private static void test10() {
		int arrIndex = 0;
		
		char[] ch = new char[str.length()];
		
		for (int i = str.length() - 1; i >= 0; i--) {
			ch[i] = str.charAt(arrIndex);
			arrIndex++;
		}
		System.out.println(ch);
	}

	private static void test09() {
		// System.out.println(str.trim()); trim()은 스페이스바가 아닌 문장 앞, 뒤의 빈 칸을 없앤다. 
		System.out.println(str.replace(" ", ""));
		System.out.println(str.replaceAll(" ", "")); // regex
	}

	private static void test08() {
		char[] ch = str.toCharArray();
		int count = 0;

		for (int i = 0; i < ch.length; i++) {
			// ch[i] -> "char" -> isUpperCase();

			if (Character.isUpperCase(ch[i])) {
				System.out.printf("%c ", ch[i]);
				count++;
			}
		}
		System.out.println("\n대문자의 갯수 : " + count);
	}

	private static void test07() {

		char[] ch = str.toCharArray();
		int count = 0;

		for (int i = 0; i < ch.length; i++) {
			// System.out.printf("%d ", ch[i]);
			if (ch[i] == 'c' || ch[i] == 'C') {
				System.out.printf("%c ", ch[i]);
				count++;

			}
		}
		System.out.println("\nc의 갯수 : " + count);
	}

	private static void test06() {
		// character 찾아서
		String target = "character";
		int start = str.indexOf(target);
		int end = start + target.length();
		String upper = str.substring(start, end);

		// 대문자로 변환
		upper = upper.toUpperCase(); // immutable하기 때문에 toUpperCase를 사용해야 한다.
		// 전체 출력
		System.out.println(str.replace(target, upper));

	}

	private static void test05() {
		System.out.println(str.replace("class", "java"));

	}

	private static void test04() {
		System.out.println(str.indexOf('c'));

	}

	private static void test03() {
		System.out.println(str.toLowerCase());

	}

	private static void test02() {
		System.out.println(str.toUpperCase());

	}

	private static void test01() {
		System.out.println(str.length());

	}
}
