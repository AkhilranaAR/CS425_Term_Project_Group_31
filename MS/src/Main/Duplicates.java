package Main;

import java.util.*;
public class Duplicates
{   
   public static boolean hasDuplicates(List<Integer> givenList) { 
	    final Set<Integer> set = new HashSet<>();
	    for (Integer val : givenList) {
	    	
	    	// if set already contains duplicate value return true immediately
	        if (!set.add(val)) {
	            return true;
	        }
	    }
	    return false;
	}
   
   public static void main(String args[]) {
	   List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
	   System.out.println(hasDuplicates(list1));
   }

}