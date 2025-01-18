package rt.exceptions;

import org.springframework.dao.DataAccessException;

public class StrangeException extends DataAccessException {
  public StrangeException(String message) {
    super(message);
  }
}