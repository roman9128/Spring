package rt.repo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rt.exceptions.StrangeException;
import rt.model.Account;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Repository
public class AccRepo {

    private final JdbcTemplate jdbc;

    public Account findAccountById(long id) throws StrangeException {
        String sql = "SELECT * FROM account WHERE id = ?";
        try {
            return jdbc.queryForObject(sql, new AccRowMapper(), id);
        } catch (Exception e) {
            throw new StrangeException("Account not found");
        }
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccRowMapper());
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }
}