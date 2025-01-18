package rt.task1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {

    @GetMapping("/about")
    public String getAbout(){
        return "about.html";
    }
}