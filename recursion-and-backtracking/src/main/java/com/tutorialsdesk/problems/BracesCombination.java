package com.tutorialsdesk.problems;

public class BracesCombination {

	private static void print(int n) {
		print("", n, n);
	}

	private static void print(String s, int open, int close) {

		if (open > close)
			return;
		if (open == 0 && close == 0) {
			System.out.println(s);
			return;
		}

		if (open < 0 || close < 0) {
			return;
		}

		print(s + "{", open - 1, close);
		print(s + "}", open, close - 1);

	}
	

	public static void main(String[] args) {
		print(3);
	}
}
