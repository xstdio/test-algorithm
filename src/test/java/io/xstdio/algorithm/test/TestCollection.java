package io.xstdio.algorithm.test;

import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class TestCollection {

	@Ignore
	@Test
	public void collection_sort() {
		List<String> list = Arrays.asList("Sort", "i", "walk", "the", "line", "a");
		// List<String> list = Arrays.asList("b", "a", "z", "p");
		// Collections.sort(list);
		list = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
	}

	@Ignore
	@Test
	public void simple_linkedlist() {
		java.util.LinkedList<String> linkedlist = new java.util.LinkedList<String>();
		linkedlist.add("Item1");
		linkedlist.add("Item5");
		linkedlist.add("Item3");
		linkedlist.add("Item6");
		linkedlist.add("Item2");

		System.out.println(linkedlist);

		linkedlist.addFirst("First Item");
		linkedlist.addLast("Last Item");
		System.out.println(linkedlist.size());
		System.out.println(linkedlist);
	}
	
	@Test
	public void hash_table() {
		Hashtable table = new Hashtable();
        table.put("Sony", "Bravia");
        table.put("Samsung", "Galaxy");
        table.put("Nokia", "Lumia");

        System.out.println("does hash table has Lumia as value : " + table.containsValue("Lumia"));
        System.out.println("does hash table Lumia as key : " + table.containsKey("Lumia"));
        
      //finding key corresponding to value in hashtable - one to one mapping
        String key= null;
        String value="Lumia";
        for(Map.Entry entry: table.entrySet()){
            if(value.equals(entry.getValue())){
                key = entry.getKey();
                break; //breaking because its one to one map
            }
        }
        System.out.println("got key from value in hashtable key:  "+ key +" value: " + value);

      //how to get from value in HashMap example - similar to Hashtable example
        HashMap map = new HashMap();
        map.put("one", 1);
        map.put("two", 2);
      
        //find key from value in HashMap Java - one to one mapping
        Integer intValue=2;
        String strKey = null;
        for(Map.Entry entry: map.entrySet()){
            if(intValue.equals(entry.getValue())){
                strKey = entry.getKey();
                break; //breaking because its one to one map
            }
        }
      
        System.out.println("key from value in hash table key:  "+ strKey +" value: " + intValue);



	}

	/*
     * detect duplicate in array by comparing size of List and Set
     * since Set doesn't contain duplicate, size must be less for an array which contains duplicates
     */
    public static boolean check_duplicate_set_size(String[] input){
        List<String> inputList = Arrays.asList(input);
        Set<String> inputSet = new HashSet<String>(inputList);
        if(inputSet.size()< inputList.size())
            return true;
        return false;
    }
    /*
     * Since Set doesn't allow duplicates add() return false
     * if we try to add duplicates into Set and this property
     * can be used to check if array contains duplicates in Java
     */
    public static boolean check_duplicate_set_add(String[] input) {
        Set<String> tempSet = new HashSet<String>();
        for (String str : input) {
            if (!tempSet.add(str)) {
                return true;
            }
        }
        return false;
    }

    @Ignore
	@Test
	public void duplicate_detection() {
		String[] dup_ar = new String[] {"one","two","three","one"};
		String[] no_dup_ar = new String[] {"one","two","three"};
		
		System.out.println("dup_check_set_size:" + check_duplicate_set_size(dup_ar));
		System.out.println("no_dup_check_set_size:" + check_duplicate_set_size(no_dup_ar));
		
		System.out.println("dup_check_set_add:" + check_duplicate_set_add(dup_ar));
		System.out.println("no_dup_check_set_add:" + check_duplicate_set_add(no_dup_ar));
	}
	
	public static String string_iterative_reverse(String str) {
		StringBuilder strBuilder = new StringBuilder();
		char[] strChars = str.toCharArray();
		for (int i = strChars.length - 1; i >= 0; i--) {
			strBuilder.append(strChars[i]);
		}
		return strBuilder.toString();
	}
	public static String string_recusive_reverse(String str) {
		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}
		System.out.printf("\n |%s|%s|%s|",str.substring(1), str.charAt(0), str);
		return string_recusive_reverse(str.substring(1)) + str.charAt(0);
	}
	
	@Ignore
	@Test
	public void string_reverse() {
		String test = "this is a test msg";
		//stringbuffer
		StringBuffer buffer = new StringBuffer(test);
		System.out.printf("|%s|\n|%s|", test, buffer.reverse().toString());
		//iterative
        System.out.printf("\nIteration: |%s|", string_iterative_reverse(test));
        //recursive
        System.out.printf("\nRecursion: |%s|", string_recusive_reverse(test));
	}

	/**
	 * Java program to find middle element of linked list in one pass. In order
	 * to find middle element of linked list we need to find length first but
	 * since we can only traverse linked list one time, we will use two pointers
	 * one which we will increment on each iteration while other which will be
	 * incremented every second iteration. so when first pointer will point to
	 * the end of linked list, second will be pointing to the middle element of
	 * linked list
	 * 
	 * @author Read more:
	 *         http://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html#ixzz4spF0oyca
	 */
	@Ignore
	@Test
	public void custom_linkedlist() {
		io.xstdio.algorithm.test.LinkedList linkedList = new LinkedList();
		io.xstdio.algorithm.test.LinkedList.Node head = linkedList.head();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));

		// finding middle element of LinkedList in single pass
		LinkedList.Node current = head;
		int length = 0;
		LinkedList.Node middle = head;

		while (current.next() != null) {
			length++;
			if (length % 2 == 0) {
				middle = middle.next();
			}
			current = current.next();
		}

		if (length % 2 == 1) {
			middle = middle.next();
		}

		System.out.println("length of LinkedList: " + length);
		System.out.println("middle element of LinkedList : " + middle);

	}
}

class LinkedList {
	private Node head;
	private Node tail;

	public LinkedList() {
		this.head = new Node("head");
		tail = head;
	}

	public Node head() {
		return head;
	}

	public void add(Node node) {
		tail.next = node;
		tail = node;
	}

	public static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {
			return this.data;
		}
	}
}
