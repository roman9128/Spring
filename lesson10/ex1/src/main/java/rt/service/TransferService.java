package rt.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rt.aspect.ToLog;
import rt.exceptions.StrangeException;
import rt.model.Account;
import rt.repo.AccRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class TransferService {
    private final AccRepo accRepo;

    @Transactional
    @ToLog
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws StrangeException {
        Account sender = accRepo.findAccountById(idSender);
        Account receiver = accRepo.findAccountById(idReceiver);
        if (sender.getAmount().longValue() > 0) {
            BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
            BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
            if (senderNewAmount.longValue() > 0) {
                accRepo.changeAmount(idSender, senderNewAmount);
                accRepo.changeAmount(idReceiver, receiverNewAmount);
            } else throw new StrangeException("Not enough money");
        }
    }

    public Boolean checkMoney(long id) {
        return accRepo.findAccountById(id).getAmount().longValue() > 0;
    }

    public List<Account> getAllAccs() {
        return accRepo.findAllAccounts();
    }
}