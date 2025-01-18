package rt.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rt.dto.TransferRequest;
import rt.model.Account;
import rt.service.TransferService;

import java.util.List;

@AllArgsConstructor
@RestController
public class AccController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccs() {
        return transferService.getAllAccs();
    }

    @GetMapping("/check/{id}")
    public Boolean checkMoney(@PathVariable Long id) {
        return transferService.checkMoney(id);
    }
}