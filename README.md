# MultiThreaded Java implementation of Fizz Buzz Game

This is a spring based java application, Its recommended to have Spring STS or Eclipse or Intellij editor.

Install Spring STS from (https://spring.io/tools/sts/all).

### Description:

The program takes a number as input(N), and returns a string from 1-N, where numbers divisible by just 3 are replaced by fizz, 5 by Buzz,  3 and 5 as fizz buzz.

#### Installation :

1. Clone and build and clean using maven
```./mvnw clean package```

2. Run the server using 
 ```./mvnw spring-boot:run```
 
### Server:
Visit ```localhost:8080``` and give any number, you can see the resulting Fizz buzz string

Errors:
If the number is large like Integer.MAX_VALUE, our browser cannot handle(RAM issue), because it needs to store very large string. Hence our program is confined to numbers less than 2,147,483,647.


