package com.test01;

import java.io.File;
import java.io.IOException;

public class MTest01 {

	public static void main(String[] args) {
		
		
		// /Users/?/test_io
		File fi = new File("C:/test_io");
		
		if (fi.exists()) {
			System.out.println("exists");
		} else {
			System.out.println("make directory");
			fi.mkdirs();
		}
		
		// fi 안에(밑에) AA라는 folder(directory) 생성
		File fiAA = new File(fi, "AA");
		fiAA.mkdir();
		
		File fiBB = new File("C:\\test_io", "BB");
		fiBB.mkdir();
		
		// AA 밑에 a.txt 파일 생성
		File aTxt = new File(fiAA, "a.txt");
		
		try {
			// checked exception // 컴파일 시 예외를 반드시 처리해야 하는 얘들.
			aTxt.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
