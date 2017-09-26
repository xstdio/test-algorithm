package io.xstdio.algorithm.test;

import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class TestPolymorphism {

	
	@Test
	public void polymorph() {
		Base b = new Base();
		Base be = new Extend();
		Extend e = new Extend();
		
		print_obj(b);
		print_obj(be);
		print_obj(e);

	}
	private void print_obj(Base o) {
		o.print();
	}
}

class Base {
	public void print() {
		System.out.println("Base");
	}
}

class Extend extends Base {
	public void print() {
		System.out.println("Extend");
	}
}