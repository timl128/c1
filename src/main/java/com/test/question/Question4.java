package com.test.question;


import java.util.*;

public class Question4 {

    /**
     * return the most common value from the input array
     * @param input
     * @return
     */
    public Integer[] findMostCommonValue(Integer[] input){


        if(input == null || input.length == 0)
            return new Integer[0];

        //O(log n)
        Arrays.sort(input);

        int max = 0 ;
        int compareNumber = input[0];
        int currentCount = 1;

        Set<Integer> common = new TreeSet<>();
        common.add(input[0]);

        int length = input.length;


        //O(n)
        for (int i = 1 ; i < length ; i++ ) {
            if(input[i] == compareNumber){
                currentCount++;
            }
            else{

                max = addResult(currentCount,max,compareNumber,common);
                compareNumber = input[i];
                currentCount = 1;
            }
        }

       addResult(currentCount,max,compareNumber,common);


        return common.toArray(Integer[]::new);
    }

    /**
     * add the current common value and return its frequency
     * @param currentCount
     * @param max
     * @param compareNumber
     * @param common
     * @return
     */
    private int addResult(int currentCount, int max, int compareNumber,Set<Integer> common){
        if(currentCount >= max)
        {
            if(currentCount > max){
                max = currentCount;
                common.clear();
            }
            common.add(compareNumber);
        }
        return max;
    }
}
