package tcr;

import java.util.Scanner;

public class area {

	public static void main(String[] args) {
		Scanner n= new Scanner (System.in);
		
		System.out.println("enter the radius");
		float radius = n.nextFloat();
		double area = 3.1416*radius* radius;
		
		System.out.println("area if curcle= "+ area);

	}

}
