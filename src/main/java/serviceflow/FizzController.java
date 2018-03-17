package serviceflow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class FizzController {
    
	//home page call
    @RequestMapping(value= {"/"},method = RequestMethod.GET)
    public String index() {
        return "fizz";
    }
    // post api call
    @RequestMapping(value= {"/fizz"},method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> fizz(@RequestParam("number") String number) throws InterruptedException {
    	Fizz result=new Fizz(number);
        return new ResponseEntity<String[]>(result.getFizzbuzz(),HttpStatus.OK);
    }
}
