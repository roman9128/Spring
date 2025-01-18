package rt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rt.model.Account;
import rt.repo.AccRepo;
import rt.service.TransferService;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ServiceUnitTest {

    @Mock
    public AccRepo accRepo;

    @InjectMocks
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

    @Test
    public void receiverNotFound() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(BigDecimal.valueOf(1000));
        given(accRepo.findAccountById(1L)).willReturn(Optional.of(sender).get());
        given(accRepo.findAccountById(2L)).willReturn(null);

        assertThrows(
                NullPointerException.class,
                () -> transferService.transferMoney(1, 2, BigDecimal.valueOf(200)));

        verify(accRepo, never()).changeAmount(anyLong(), any());
    }

    @Test
    public void checkMoneyTest() {
        Account account = new Account();
        account.setId(1);
        account.setAmount(BigDecimal.valueOf(1000));
        given(accRepo.findAccountById(account.getId())).willReturn(Optional.of(account).get());
        Assertions.assertTrue(transferService.checkMoney(account.getId()));
    }
}