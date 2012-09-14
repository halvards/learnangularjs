package com.thoughtworks.learnangularjs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldJsonController {
    @RequestMapping(value = "/{name}", method = GET)
    public @ResponseBody Greeting getAccount(@PathVariable String name) {
        return new Greeting(name);
    }
}
