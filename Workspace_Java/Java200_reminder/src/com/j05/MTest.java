package com.j05;

public class MTest {

	public static void main(String[] args) {
		
		// 비버랑, 독수리랑 객체 만들어서
		// 비버의 울음소리 : ??
		// 독수리의 울음소리 : ??
		Beavor beaver = new Beavor("비버", 10);
		beaver.bark("아악!");
		
		Animal eagle = new Eagle("독수리", 5);
		eagle.bark("삐약");
		
	}
}
