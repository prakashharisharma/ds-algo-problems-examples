package com.tutorialsdesk.problems;

public class TowersOfHanoi {

	private static void moveDisks(int n, String source, String auxiliary, String destination){
		
		if (n == 1) {
		   // When n==1, it means we are left with only one disk, so directly move it from source to destination.
			System.out.println(source + " -> " + destination); 
		}else{
		   // Move (n-1 disk) from Source Peg to Auxiliary Peg
			moveDisks(n - 1, source, destination, auxiliary);    
		   //Move last nth disk to Destination Peg.
			System.out.println(source + " -> " + destination);  
		 
		   //Move (n-1 disk) from Auxiliary Peg to Destination Peg.
			moveDisks(n - 1, auxiliary, source, destination); 
		}
	}
		 
	public static void main(String[] args) {
			 
		moveDisks(3, "source peg", "helper peg", "destination peg");
		  
	}
}
