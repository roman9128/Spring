package rt.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rt.model.Account;
import rt.repo.AccRepo;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferService {
    private final AccRepo accRepo;

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accRepo.findAccountById(idSender);
        Account receiver = accRepo.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accRepo.changeAmount(idSender, senderNewAmount);
        accRepo.changeAmount(idReceiver, receiverNewAmount);

        throw new RuntimeException("shit happened");
    }

    public List<Account> getAllAccs() {
        return accRepo.findAllAccounts();
    }
}