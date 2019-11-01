package ch.exercice_gc;

import java.lang.management.GarbageCollectorMXBean;

public class MyGC {
	
	static int[] n;
	
	public static void main(String[] args) {
		while(true) {
			n = new int[100000000];
		}
	}
}
