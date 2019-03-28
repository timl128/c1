package com.test.question;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

public class HttpRunnable implements Runnable {

    private BlockingQueue<Message> queue;
    private ConcurrentHashMap<String,Boolean> concurrentHashMap;
    private ExecutorService httpThread;


    public HttpRunnable(BlockingQueue<Message> queue,
                        ConcurrentHashMap<String,Boolean> concurrentHashMap,
                        ExecutorService httpThread){

        this.queue = queue;
        this.concurrentHashMap = concurrentHashMap;
        this.httpThread = httpThread;
    }

    @Override
    public void run() {

        while(true){

            String url = "";
            try {

                Message message = queue.take();
                url = message.getUrl();
                boolean stop = message.getStop();
                if(stop){

                   break;
                }

            } catch (InterruptedException e) {

            }


            Boolean found = concurrentHashMap.getOrDefault(url,null);
            if(found == null){
                httpThread.submit( subProcess(url));
            }

        }

        httpThread.shutdown();

        try {
            if (!httpThread.awaitTermination(60, TimeUnit.SECONDS)) {
                httpThread.shutdownNow();
            }
        } catch (InterruptedException ex) {
            httpThread.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }

    /**
     * call GET
     * @param url
     */
    private boolean callHttpGet(String url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection)new URL(url ).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode() == 200 ? true : false;
    }

    private Callable<Boolean> subProcess(String url){
        return () -> checkResponding(url);

    }



    private Boolean checkResponding(String url){

        Boolean result = false;
        try {
            result = callHttpGet(url);
            if(result){
                System.out.println(url);
            }


        } catch (IOException e) {

        }
        concurrentHashMap.put(url,result);

        return result;
    }

}
