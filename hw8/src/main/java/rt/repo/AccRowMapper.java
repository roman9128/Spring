package rt.repo;

import org.springframework.jdbc.core.RowMapper;
import rt.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setAmount(rs.getBigDecimal("amount"));
        return account;
    }
}