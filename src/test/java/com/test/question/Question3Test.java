package com.test.question;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Question3Test {

    private Question3 question3;

    @Before
    public void setup(){
        question3 = new Question3();
    }

    @Test
    public void findTriangleArea() {

        BigDecimal result = question3.findTriangleArea(3,4,5);

        assertEquals(new BigDecimal("6"),result);
    }

    @Test(expected = InvalidTriangleException.class)
    public void findTriangleAreaWithInvalidSide() {

        question3.findTriangleArea(1,1,500);

    }

    @Test(expected = InvalidTriangleException.class)
    public void findTriangleAreaWithNegative() {

        question3.findTriangleArea(-1,1,1);

    }
}