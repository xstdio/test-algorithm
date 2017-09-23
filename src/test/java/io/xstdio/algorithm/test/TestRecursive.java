package io.xstdio.algorithm.test;

import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class TestRecursive {

	public int simple_recursive(int aVariable) {
		// System.out.println(aVariable);
		aVariable--;
		if (aVariable == 0)
			return 0;
		return simple_recursive(aVariable);
	}

	public long fibonacci_recursive(int n1, int n2, int idx, int stop) {
		// System.out.printf("\n%d %d %d %d",n1, n2, idx, stop);
		if (idx == 3) {
			System.out.printf("1:%d\n2:%d", n1, n2);
		}
		System.out.printf("\n%d:%d", idx, (n1 + n2));
		if (idx == stop) {
			return n1 + n2;
		}
		idx++;
		return fibonacci_recursive(n2, n1 + n2, idx, stop);
	}

	public int factorial_recursive(int number) {
		// base case
		if (number == 0) {
			return 1;
		}
		return number * factorial_recursive(number - 1);
	}
	
	public long reverse_recursive(long number, long reverse) {
		if(number == 0)
			return reverse;
		reverse = reverse*10 + number%10;
		
		return reverse_recursive(number/10, reverse);
	}

//	@Ignore
	@Test
	public void recursive() {
		// simple
		System.out.printf("===\nsimple:%s\n===\n", simple_recursive(10));
		// fibonacci
		System.out.printf("\n===\nfibonacci:%s", fibonacci_recursive(0, 1, 3, 40));
		// factorial
		System.out.printf("\n===\nfactorial:%s", factorial_recursive(5));
		// reverse
		System.out.printf("\n===\nreverse:13321:%d",reverse_recursive(13321, 0));
	}

	int min(int x, int y, int z) {
		if (x < y && x < z)
			return x;
		if (y < x && y < z)
			return y;
		else
			return z;
	}

	int editDist(String str1, String str2, int m, int n) {
		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if (m == 0)
			return n;

		// If second string is empty, the only option is to
		// remove all characters of first string
		if (n == 0)
			return m;

		// If last characters of two strings are same, nothing
		// much to do. Ignore last characters and get count for
		// remaining strings.
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return editDist(str1, str2, m - 1, n - 1);

		// If last characters are not same, consider all three
		// operations on last character of first string, recursively
		// compute minimum cost for all three operations and take
		// minimum of three values.
		return 1 + min(editDist(str1, str2, m, n - 1), // Insert
				editDist(str1, str2, m - 1, n), // Remove
				editDist(str1, str2, m - 1, n - 1) // Replace
		);
	}
	@Ignore
	@Test
	public void edit_distance() {
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(editDist(str1, str2, str1.length(), str2.length()));
	}
}