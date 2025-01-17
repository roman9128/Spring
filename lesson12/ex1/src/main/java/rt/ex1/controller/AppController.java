package rt.ex1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rt.ex1.model.Account;
import rt.ex1.service.FileOut;

@RestController
@RequiredArgsConstructor
public class AppController {

    @Autowired
    private FileOut fileOut;


    @PostMapping("/add")
    public String addAcc(@RequestBody Account account){
        fileOut.writeToFile(account.getName()+".txt", account.toString());
        return "ok";
    }
}
