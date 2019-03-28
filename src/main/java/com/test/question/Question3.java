package com.test.question;

import java.math.BigDecimal;
import java.math.MathContext;

public class Question3 {

    /**
     * find triangle area by Hero's Formula
     * @see <a href="https://www.mathopenref.com/heronsformula.html">Hero's Formula</a>
     * @param a
     * @param b
     * @param c
     * @return
     */
    public BigDecimal findTriangleArea(Integer a,Integer b,Integer c){

        containsNoNegativeNumber(a,b,c);
        isValidTriangle(a,b,c);

        BigDecimal sideA = BigDecimal.valueOf(a);
        BigDecimal sideB = BigDecimal.valueOf(b);
        BigDecimal sideC = BigDecimal.valueOf(c);

        BigDecimal pValue = sideA.add(sideB)
                .add(sideC).divide(new BigDecimal("2"));


        BigDecimal step1 = pValue.subtract(sideA);
        BigDecimal step2 = pValue.subtract(sideB);
        BigDecimal step3 = pValue.subtract(sideC);

        BigDecimal step4 = step1.multiply(step2)
                                .multiply(step3)
                            .multiply(pValue).sqrt(MathContext.DECIMAL128);


        return step4;
    }

    /**
     * if the three sides can form a triangle
     * @param a
     * @param b
     * @param c
     * @return
     */
    private boolean isValidTriangle(Integer a,Integer b,Integer c){

        if( a + b > c && a  + c > b && b + c > a)
            return true;

        throw new InvalidTriangleException();
    }

    private boolean containsNoNegativeNumber(Integer a,Integer b,Integer c){

        if(a > 0 && b > 0 && c > 0)
            return true;

        throw new InvalidTriangleException();

    }

}
