package com.test.question;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question1Test {

	private Question1 question1;

	@Before
	public void setup(){
		question1 = new Question1();
	}

	@Test
	public void testIsNullOrEmptyWithString() {

		boolean result = question1.isNullOrEmpty("a");
		assertFalse(result);
	}

	@Test
	public void testIsNullOrEmptyWithNull() {

		boolean result = question1.isNullOrEmpty(null);
		assertTrue(result);
	}

	@Test
	public void testIsNullOrEmptyWithEmpty() {

		boolean result = question1.isNullOrEmpty("");
		assertTrue(result);
	}

	@Test
	public void testIsNullOrEmptyWithStringNull() {

		boolean result = question1.isNullOrEmpty("null");
		assertFalse(result);
	}

	@Test
	public void testIsNullOrEmptyWithString1() {

		boolean result = question1.isNullOrEmpty("asfdafsafsaf");
		assertFalse(result);
	}
}