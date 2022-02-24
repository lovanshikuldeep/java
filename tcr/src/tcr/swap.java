package tcr;

import java.util.Scanner;

public class swap {
	public static void main (String[] args )
	{
		int num1,num2,temp;
		Scanner x=new Scanner(System.in);
		System.out.println("enter two number");
		num1  = x.nextInt();
		num2= x.nextInt();
		
		
		temp =num1;
		num1=num2;
		num2=temp;
		
		System.out.println("num1" +num1);
		System.out.println("num2 ="+num2);
	}

}
