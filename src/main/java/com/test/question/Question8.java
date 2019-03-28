package com.test.question;

import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * assume the html content is non null and valid html content
 * GET is the only method
 * html regex reference :
 * https://examples.javacodegeeks.com/core-java/util/regex/matcher/extract-html-links-with-java-regular-expression-example/
 */
public class Question8 {

    private ConcurrentHashMap<String,Boolean> concurrentHashMap
            = new ConcurrentHashMap<>();


    private static final String HTML_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
    private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

    private Matcher mTag, mLink;
    private Pattern pTag, pLink;


    private BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public Question8(){

        pTag = Pattern.compile(HTML_TAG_PATTERN);
        pLink = Pattern.compile(HTML_HREF_TAG_PATTERN);
    }

    /**
     * run the process
     * @param htmlContent
     */
    public void run(String htmlContent){

        ExecutorService httpThread = Executors.newFixedThreadPool(4);

        HttpRunnable httpRunnable = new HttpRunnable(queue,concurrentHashMap,httpThread);

        Thread listenThread = new Thread(httpRunnable);

        listenThread.start();


        mTag = pTag.matcher(htmlContent);

        while (mTag.find()) {

            String href = mTag.group(1);     // get the values of href

            mLink = pLink.matcher(href);

            while (mLink.find()) {

                String link = mLink.group(1);
                link = link.replaceAll("'", "");
                link = link.replaceAll("\"", "");

                queue.add(new Message(link));
            }

        }

        Message stopMessage = new Message("");
        stopMessage.setStop(true);
        queue.add(stopMessage);

        try {

            listenThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



}
