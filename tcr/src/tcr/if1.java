package tcr;

import java.util.Scanner;

public class if1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner (System.in);
     System.out.println("enter the number");
     int marks = sc.nextInt();
     if(marks>=33) {
    	 System.out.println("pass");
     }else {
    	 System.out.println("fail");
     }
	}

}
