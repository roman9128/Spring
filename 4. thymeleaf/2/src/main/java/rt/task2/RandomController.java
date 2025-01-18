package rt.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RandomController {

    @Value("${data.parameter.minp:0}")
    private Integer minp;
    @Value("${data.parameter.maxp:1}")
    private Integer maxp;

    @Autowired
    private RandomService service;

    @GetMapping("/random")
    public String getNumber(Model model) {
        model.addAttribute("number", service.sendNumber());
        return "random";
    }

    @GetMapping("/random2/{min}/{max}")
    public String getNumberWithin(Model model,
                                  @PathVariable("min") int min,
                                  @PathVariable("max") int max){
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", service.sendNumberWithin(min, max));
        return "random2";
    }

    @GetMapping("/random4/{min}/{max}")
    public String getNumberWithinAndDefault(Model model,
                                  @PathVariable("min") int min,
                                  @PathVariable("max") int max){
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("minp", minp);
        model.addAttribute("maxp", maxp);
        model.addAttribute("number", service.sendNumberWithin(min, max));
        return "random4";
    }

    @GetMapping("/random3")
    public String getNumberWithinParam(Model model,
                                  @RequestParam("min") Integer min,
                                  @RequestParam("max") Integer max){
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", service.sendNumberWithin(min, max));
        return "random3";
        //http://localhost:8080/random3?min=3&max=10
    }
}
