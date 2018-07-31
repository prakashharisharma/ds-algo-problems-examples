package com.tutorialsdesk.problems;

public class PowerSum {

    static int res = 0;
    
    static int checkRecursive(int num, int x, int k, int pow)
    {
        if (x == 0) 
            res++;
         
        int r = (int) Math.floor(Math.pow(num, 1.0 / pow));
 
        for (int i = k + 1; i <= r; i++) {
        	int a = x - (int)Math.pow(i, pow);
        	if (a >= 0) {
        		checkRecursive(num, x - (int)Math.pow(i, pow), i, pow);
        	}
        }
        
        return res;
    }
     
    // Wrapper over checkRecursive()
    static int check(int num, int pow)
    {
        return checkRecursive(num, num, 0, pow);
    }
 
    public static void main(String[] args)
    { 
        System.out.println(check(25, 2));
    }

}
