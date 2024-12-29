package rt.task1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rt.task1.AccNotFoundException;
import rt.task1.model.Account;
import rt.task1.repo.AccRepo;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccRepo accRepo;

    public TransferService(AccRepo accRepo) {
        this.accRepo = accRepo;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws AccNotFoundException {
        Account sender = accRepo.findById(idSender).orElseThrow(AccNotFoundException::new);
        Account receiver = accRepo.findById(idReceiver).orElseThrow(AccNotFoundException::new);
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        accRepo.changeAmount(idSender, senderNewAmount);
        accRepo.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccs() {
        return accRepo.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accRepo.findAccountsByName(name);
    }
}