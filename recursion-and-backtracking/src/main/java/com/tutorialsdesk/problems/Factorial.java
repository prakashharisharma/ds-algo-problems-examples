package com.tutorialsdesk.problems;

public class Factorial {

	private static int factorial(int n) {
		
		if (n==1) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		
		int num = 3;
		
		int result = factorial(num);
		
		System.out.println(result);
		
	}
}
