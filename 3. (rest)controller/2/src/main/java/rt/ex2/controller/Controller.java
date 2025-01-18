package rt.ex2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/ciao")
    public String bye(){
        return "ciao";
    }
}
