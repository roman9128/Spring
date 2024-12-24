package rt.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomController {

    @Autowired
    private RandomService service;

    @GetMapping("/random")
    public String getNumber(Model model){
        model.addAttribute("number", service.sendNumber());
        return "random";
    }
}
