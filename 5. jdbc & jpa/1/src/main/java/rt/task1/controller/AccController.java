package rt.task1.controller;

import org.springframework.web.bind.annotation.*;
import rt.task1.dto.TransferRequest;
import rt.task1.model.Account;
import rt.task1.service.TransferService;

@RestController
public class AccController {

    private final TransferService transferService;

    public AccController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccs(@RequestParam(required = false) String name) {
        if (name == null) {
            return transferService.getAllAccs();
        } else {
            return transferService.findAccountsByName(name);
        }

    }
}
