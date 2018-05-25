package com.lzw;

import java.util.*;

public class UseCase2<T extends List> {
	
	public static void main(String[] args) {
		UseCase2<ArrayList> l1 = new UseCase2<ArrayList>();
		UseCase2<LinkedList> l2 = new UseCase2<LinkedList>();
		// LimitClass<HashMap> l3=new LimitClass<HashMap>();
	}
	
}
