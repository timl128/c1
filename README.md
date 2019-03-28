# Questions

### choices
It includes question 1 ,2,3,4,5,6,8



### Requirement 
1. jdk 1.11+
2. internet
3. mysql

### Set up

1. Please download the source code from git hub
2. run `./gradlew build -Dorg.gradle.java.home=path test` for testing question 1,2,3,4,8

P.S. one test will need around 35 seconds because it downloads content from `https://news.com.au` for returning 192 links.

3. run `[jdk1.11_path]/java  -jar build/libs/question-1.0-SNAPSHOT.jar` for running the main class



### Details
You will see the following output by running the main class.

```
false
q2 60 Time : 21ms: 
q2 125896543223 Time : 50ms: 
6
q4 with 7 elements Time : 2ms: 
q4 with 10000 elements Time : 13ms: 
q4 with 100000 elements Time : 57ms: 
https://www.google.com.au/imghp?hl=en&tab=wi
https://www.youtube.com/?gl=AU&tab=w1
https://play.google.com/?hl=en&tab=w8
https://mail.google.com/mail/?tab=wm
https://news.google.com.au/nwshp?hl=en&tab=wn
https://drive.google.com/?tab=wo
https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.com/
https://www.google.com/url?q=https://about.google/intl/en_au/stories/pedalingforpeace%3Futm_source%3Dgoogle%26utm_medium%3Dhpp%26utm_campaign%3DAustralia&amp;source=hpp&amp;id=19011495&amp;ct=3&amp;usg=AFQjCNEycIYzgUTPd1JTsBEwMHpIIXPxiQ&amp;sa=X&amp;ved=0ahUKEwji27bZj6ThAhXKfCsKHejAAKkQ8IcBCAU
https://maps.google.com.au/maps?hl=en&tab=wl
https://www.google.com.au/intl/en/about/products?tab=wh
https://www.google.com/setprefdomain?prefdom=AU&amp;prev=https://www.google.com.au/&amp;sig=K_wXqx1mjX1g1-qEyUe2A2MMP7alI%3D
q8 with https://google.com/  Time : 2212ms: 

Process finished with exit code 0


```

You can see the run time. 


q1 is O(1)

q2 is O(n)

q4 is O(n)


#### solution for question 8 

Assumption :  
Assume the html content is non null and valid html content
GET is the only method

Once the application find a url from the html content, it sends the url to a queue.
Another thread is listening the queue. It assigns the validation task to available threads from pool.
It can save time for waiting for all urls.

It will send a stop signal after reading all the html content.
