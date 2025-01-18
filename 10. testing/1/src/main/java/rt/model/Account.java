package rt.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@Data
public class Account {

    @Id
    private long id;
    private String name;
    private BigDecimal amount;
}
