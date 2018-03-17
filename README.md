# MultiThreaded Java implementation of Fizz Buzz Game

This is a spring based java application, Its recommended to have Spring STS or Eclipse or Intellij editor.

Install Spring STS from (https://spring.io/tools/sts/all).

### Description:

The program takes a number as input(N), and returns a string from 1-N, where numbers divisible by just 3 are replaced by Fizz, 5 by Buzz,  3 and 5 as Fizz Buzz.

#### Installation :

1. Clone and build and clean using maven
```./mvnw clean package```

2. Run the server using
 ```./mvnw spring-boot:run```
  
### Server:

Visit ```localhost:8080``` and give any number, you can see the resulting Fizz buzz string

### Performance:

1. Limited number of threads to 1000. If it's more there is chance of high memory usage.

2. Used pure Javascript in ajax while rendering, since it's the fastest. The string is added to DOM element for when string crosses 2^20 length. Browsers have different type of breaking points, while 
coming to strings in javascript.

3. Used array response, not string response in API call, since string has length limitation of 2^31-1
in java.

### Errors:

If the number is large like Integer.MAX_VALUE, our browser cannot handle(RAM issue), because it needs to store very large string. Hence our program is confined to numbers less than 2,147,483,647. Actually, it should be less than that for many systems. My browser hangs even for 21474836, even though it gets response from Backend. 




