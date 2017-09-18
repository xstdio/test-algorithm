package io.xstdio.algorithm.test;

import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class TestRecursive {

	public int simple_recursive(int aVariable) {
//		System.out.println(aVariable);
		aVariable--;
		if (aVariable == 0)
			return 0;
		return simple_recursive(aVariable);
	}
	public long fibonacci_recursive(int n1, int n2, int idx, int stop) {
//		System.out.printf("\n%d %d %d %d",n1, n2, idx, stop);
		if(idx==3) {
			System.out.printf("1:%d\n2:%d",n1,n2);
		}
		System.out.printf("\n%d:%d",idx, (n1+n2));
		
		if(idx==stop) {
			return n1+n2;
		}
		idx++;
		return fibonacci_recursive(n2,n1+n2,idx,stop);
	}
	public int factorial_recursive(int number){       
        //base case
        if(number == 0){
            return 1;
        }
        return number*factorial_recursive(number -1); 
    }


//	@Ignore
	@Test
	public void recursive() {
		
		//simple
		System.out.printf("===\nsimple:%s\n===\n",simple_recursive (10));
		//fibonacci
		System.out.printf("\n===\nfibonacci:%s",fibonacci_recursive (0,1,3,40));
		//factorial
		System.out.printf("\n===\nfactorial:%s", factorial_recursive(5)); 
	}
	
	
}