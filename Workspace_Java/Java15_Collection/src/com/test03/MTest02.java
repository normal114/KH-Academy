package com.test03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.score.Score;

public class MTest02 {

	public static void main(String[] args) {
		// Score 객체 3개 만들자.
		// 이름은 홍길동, 이순신, 김선달. 점수는 알아서.
		Score s1 = new Score();
		s1.setName("홍길동");
		s1.setKor(100);
		s1.setEng(56);
		s1.setMath(70);

		Score s2 = new Score("이순신", 57, 81, 100);

		Score s3 = new Score("김선달", 79, 100, 50);
		// Score 객체를 관리할 수 있는 Set 객체를 만들자.
		// Set type에, HashSet으로 만들자.
		Set<Score> set = new HashSet<Score>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(new Score("샤넬", 100, 100, 100));

		printCollection(set);
		transElement(set, "홍길동", 10);
	}

	public static void transElement(Set<Score> set, String target, int kor) {
		// set에서 "홍길동"을 찾아서, 국어점수를 10점으로 바꾸고, 전체 출력
		// 찾을 때 iterator를 사용하자!!

		Iterator<Score> itr = set.iterator();
		while (itr.hasNext()) {
			/*
			 * if (itr.next().getName() == target) { // next를 두 번 하기 때문에 에러가 난다.
			 * itr.next().setKor(kor); }
			 */
			Score temp = itr.next();
			if (temp.getName().equals(target)) { // 문자열 비교는 equals이다.
				temp.setKor(kor);
			}
		}
		// 출력
		Iterator<Score> ir = set.iterator();
		while (ir.hasNext()) {
			System.out.println(ir.next());
		}
	}

	public static void printCollection(Set<Score> set) {
		// 1.
		for (Score sc : set) {
			System.out.println(sc);
		}

		System.out.println("---------------");

		// 2.
		Object[] oArr = set.toArray();
		for (int i = 0; i < oArr.length; i++) {
			// System.out.println(oArr[i]);
			// System.out.println(oArr[i].getName()); // Object type으로 감싸져 있다. 따라서 score가
			// 가지고 있는 getName을 사용할 수 없다.
			System.out
					.println(((Score) oArr[i]).getName() + " \t " + String.format("%.2f", ((Score) oArr[i]).getAvg()));
			// 따라서 (Score) 같이 자식으로 바꿔야 getName사용이 가능하다.
			// System.out.printf("%s \t %.2f\n", ((Score)oArr[i]).getName(),
			// ((Score)oArr[i]).getAvg());
		}

		// 3. Iterator : 컬렉션 저장 요소를 읽어오는 표준화된 방법
		Iterator<Score> iterator = set.iterator(); // set.Score의 내용을 가져온다.
		while (iterator.hasNext()) { // 다음에 내용이 있니 물어보면서 하나씩 가져온다.
			System.out.println(iterator.next()); // 내용을 가져오면서 다시 다음으로 넘어가서 가져온다.
		}

	}

}
