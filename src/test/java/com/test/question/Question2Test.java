package com.test.question;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Question2Test {

	private Question2 question2;

	@Before
	public void setup(){
		question2 = new Question2();
	}

	@Test
	public void testFindFactorWith60() {

		List<Long> result = question2.findFactor(60);
		List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 10L, 12L, 15L, 20L, 30L, 60L);
		assertEquals(12,result.size());
		assertEquals(list,result);
	}

	@Test
	public void testFindFactorWith42() {

		List<Long> result = question2.findFactor(42);
		List<Long> list = Arrays.asList(1L, 2L, 3L, 6L, 7L, 14L, 21L, 42L);
		assertEquals(8,result.size());
		assertEquals(list,result);
	}

	@Test
	public void testFindFactorWith11() {

		List<Long> result = question2.findFactor(11);
		List<Long> list = Arrays.asList(1L, 11L);
		assertEquals(2,result.size());
		assertEquals(list,result);
	}
}