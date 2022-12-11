package Main;

import java.util.*;


public class MyPancake implements Pancake { 



	public static void main(String[] args) { 
	 List x = new ArrayList (); 
	 x.add("3");
	
	 x.add("7");
	
	 x.add("5"); 
	 List y = new MyPancake().doStuff(x); 
	 y.add("1"); 
	 System.out.println(x); 
	} 
	public List doStuff(List z) { 
	 z.add("9"); 
	 return z; 
	}
} 


interface Pancake { 
 List doStuff(List s); 
}
