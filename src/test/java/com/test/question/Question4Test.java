package com.test.question;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question4Test {

    private Question4 question4;

    @Before
    public void setup(){
        question4 = new Question4();
    }

    @Test
    public void findMostCommonValue() {

        Integer[] input = new Integer[]{5, 4, 3, 2, 4, 5, 1, 6, 1, 2, 5, 4};
        Integer[] expected = new Integer[]{4,5};

        Integer[] result =  question4.findMostCommonValue(input);

        assertArrayEquals(expected,result);
    }


    @Test
    public void findMostCommonValueExample2() {

        Integer[] input = new Integer[]{1, 2, 3, 4, 5, 1, 6, 7};
        Integer[] expected = new Integer[]{1};

        Integer[] result =  question4.findMostCommonValue(input);

        assertArrayEquals(expected,result);
    }

    @Test
    public void findMostCommonValueExample3() {

        Integer[] input = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7};

        Integer[] result =  question4.findMostCommonValue(input);

        assertArrayEquals(expected,result);
    }

    @Test
    public void findMostCommonValueExample4() {

        Integer[] input = new Integer[]{1, 2, 3, 4, 5, 6, 6};
        Integer[] expected = new Integer[]{6};

        Integer[] result =  question4.findMostCommonValue(input);

        assertArrayEquals(expected,result);
    }

    @Test
    public void findMostCommonValueExample5() {

        Integer[] input = new Integer[]{ 6};
        Integer[] expected = new Integer[]{6};

        Integer[] result =  question4.findMostCommonValue(input);

        assertArrayEquals(expected,result);
    }

    @Test
    public void findMostCommonValueWithNull() {

        Integer[] expected = new Integer[]{};

        Integer[] result =  question4.findMostCommonValue(null);

        assertArrayEquals(expected,result);
    }

    @Test
    public void findMostCommonValueWithEmpty() {

        Integer[] input = new Integer[]{};
        Integer[] expected = new Integer[]{};

        Integer[] result =  question4.findMostCommonValue(input);

        assertArrayEquals(expected,result);
    }
}