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

            randomBug(); // метод вызова случайной ошибки для проверки транзакций

            accRepo.changeAmount(idSender, senderNewAmount);
            accRepo.changeAmount(idReceiver, receiverNewAmount);
        }
    }

    public Boolean checkMoney(long id) {
        return accRepo.findAccountById(id).getAmount().longValue() > 0;
    }

    private void randomBug() throws RuntimeException {
        int err = new Random().nextInt(0, 1000);
        if (err % 2 == 0) {
            throw new RuntimeException("random bug!");
        }
    }

    public List<Account> getAllAccs() {
        return accRepo.findAllAccounts();
    }
}