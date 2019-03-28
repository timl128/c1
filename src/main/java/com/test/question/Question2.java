package com.test.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question2 {

	/**
	 * find the factor of a number
	 * The worst case is O(n)
	 * @param number
	 * @return
	 */
	public List<Long> findFactor(long number){

		List<Long> answer = new ArrayList<>();

		if(number > 0 ){

			long max = number;

			boolean isEvenNumber = number % 2 == 0 ? true : false;

			answer.add(1L);
			answer.add(number);
			for(long i = 2 ; i < max; i++){

				if(!isEvenNumber && i % 2 == 0 )
					continue;


				if(number % i == 0 )
				{
					answer.add(i);
					long other = number/i;
					answer.add(other);
					max = other;
				}
			}
			Collections.sort(answer);
		}


		return answer;
	}
}
