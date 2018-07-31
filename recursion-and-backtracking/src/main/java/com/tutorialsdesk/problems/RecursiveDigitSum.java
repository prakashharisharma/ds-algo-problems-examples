package com.tutorialsdesk.problems;

public class RecursiveDigitSum {

	private static int digitSum(int num) {
		
		if(num < 10) {
			return num;
		}else {
			return digitSum(sum(num));
		}
	}
	
	private static int sum(int num) {
		
		if(num ==0) {
			return 0;
		}else {
			return num%10 + sum(num/10);
		}
		
	}
	
	public static void main(String[] args) {
		
		int result = digitSum(148148148);
		
		System.out.println(result);
	}
	
}
