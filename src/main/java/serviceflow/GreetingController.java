package serviceflow;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    
    }
    
    @RequestMapping(value= {"/"},method = RequestMethod.GET)
    public String index(@RequestParam(value="number",defaultValue="30") String number) {
        return "fizz";
    }
    
    @RequestMapping(value= {"/fizz"},method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String>[] fizz(@RequestParam("number") String number) {
    	Fizz result=new Fizz(number);
        return result.getFizzbuzz();
    }
}
