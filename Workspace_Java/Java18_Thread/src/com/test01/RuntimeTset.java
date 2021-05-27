package com.test01;

import java.io.IOException;

public class RuntimeTset {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();

		try {
			Process prc = rt.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
