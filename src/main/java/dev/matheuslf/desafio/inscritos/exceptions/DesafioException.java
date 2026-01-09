package dev.matheuslf.desafio.inscritos.exceptions;

import org.springframework.http.ProblemDetail;

public class DesafioException extends  RuntimeException {

  public DesafioException(String message) {
    super(message);
  }

  public DesafioException(Throwable cause) {
    super(cause);
  }

  public ProblemDetail toProblemDetail() {
    var pd = ProblemDetail.forStatus(500);

    pd.setTitle("Internal Server Error");
    pd.setDetail("Contact Support");

    return pd;
  }
}
