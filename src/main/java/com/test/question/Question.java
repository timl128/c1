package com.test.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {

	public static void main (String arg[]){

		Question1 question1 = new Question1();

		//Expected false
		System.out.println(question1.isNullOrEmpty("Hi"));

		runQuestion2(60);
		runQuestion2(125896543223L);

		Question3 question3 = new Question3();
		//Expected 6
		System.out.println(question3.findTriangleArea(3,4,5));


		runQuestion4(new Integer[]{1,2,3,4,5,6,7});
		runQuestion4(generateQuestion4Data(10000));
		runQuestion4(generateQuestion4Data(100000));

		runQuestion8("https://google.com/");

	}

	/**
	 * print the run time
	 * @param message
	 * @param startTime
	 */
	private static void getRunTimeInMilSecond(String message ,long startTime){
		long diff =  System.currentTimeMillis() - startTime;
		System.out.println(String.format("%s Time : %sms: ",message,diff));
	}


	/**
	 *
	 */
	private static void runQuestion2(long number){
		Question2 question2 = new Question2();
		long start = System.currentTimeMillis();
		question2.findFactor(number);
		getRunTimeInMilSecond("q2 " + number,start);
	}

	/**
	 * run question 4
	 * @param array
	 */
	private static void runQuestion4(Integer[] array){
		Question4 question4 = new Question4();
		long start = System.currentTimeMillis();
		question4.findMostCommonValue(array);
		getRunTimeInMilSecond(String.format("q4 with %s elements",array.length) ,start);
	}

	/**
	 * generate random data for question 4
	 * @param num
	 * @return
	 */
	private static Integer[] generateQuestion4Data(int num){

		List<Integer> list = new ArrayList<>();
		Random rand = new Random();

		for(int i = 0; i < num ; i++){
			int n = rand.nextInt(500000);
			list.add(n);
		}

		return list.toArray(Integer[]::new);
	}

	private static void runQuestion8(String address){
		Question8 question8 = new Question8();
		String content= getHtmlContent(address);
		long start = System.currentTimeMillis();
		question8.run(content);
		getRunTimeInMilSecond(String.format("q8 with %s ",address) ,start);
	}


	/**
	 * get html content from internet
	 * @param address
	 * @return
	 */
	public static String  getHtmlContent(String address) {

		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;

		StringBuilder stringBuilder = new StringBuilder();

		try {
			url = new URL(address);
			is = url.openStream();  // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		return stringBuilder.toString();
	}

}
