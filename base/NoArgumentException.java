/**
 *@author Otávio Goes
 *@date 15/03/2020
 *@brief Custom Exception, threw by main if has no argument with the file path
 * */
package base;

import java.lang.RuntimeException;

public class NoArgumentException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public NoArgumentException(String errorMessage) {
    super(errorMessage);
  }
}
