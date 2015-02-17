package fr.beneth;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	public static void main(String args[]) {

		System.out.println("integer version");
		List<Integer> integerList = new ArrayList();
		System.out.println(String.format("Before looping: %d", Runtime.getRuntime().freeMemory()));
		for (int i = 0; i < 237000 ; ++i) {
			integerList.add(i);
		}
		
		System.out.println(String.format("After looping: %d", Runtime.getRuntime().freeMemory()));
		
		System.out.println("Num of elems: " + integerList.size());
		
		System.out.println("string version:");
		List<String> stringsList = new ArrayList();
		System.out.println(String.format("Before looping: %d", Runtime.getRuntime().freeMemory()));
		for (int i = 0; i < 237000 ; ++i) {
			stringsList.add(String.format("%06d", i));
		}
		
		System.out.println(String.format("After looping: %d", Runtime.getRuntime().freeMemory()));
		
		System.out.println("Num of elems: " + stringsList.size());
		
		

	}
}
