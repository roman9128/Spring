package rt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import rt.model.Account;
import rt.repo.AccRepo;
import rt.service.TransferService;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ServiceIntegrationTest {

    @MockBean
    public AccRepo accRepo;
    @Autowired
    public TransferService transferService;

    @Test
    public void moneyTransferTest() {
        Account sender = new Account();
        sender.setId(1);
        sender.setName("TestSender");
        sender.setAmount(BigDecimal.valueOf(1000));
        Account receiver = new Account();
        receiver.setId(2);
        receiver.setName("TestReceiver");
        receiver.setAmount(BigDecimal.valueOf(1000));
        given(accRepo.findAccountById(sender.getId())).willReturn(Optional.of(sender).get());
        given(accRepo.findAccountById(receiver.getId())).willReturn(Optional.of(receiver).get());

        transferService.transferMoney(1, 2, BigDecimal.valueOf(200));

        verify(accRepo).changeAmount(1, BigDecimal.valueOf(800));
        verify(accRepo).changeAmount(2, BigDecimal.valueOf(1200));
    }
}
