package error;

import javax.servlet.ServletException;

public class NoidException extends ServletException{
  public NoidException(String mess, Throwable e){
    super(mess,e);
  }
}
