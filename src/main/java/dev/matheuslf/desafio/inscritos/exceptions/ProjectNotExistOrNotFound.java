package dev.matheuslf.desafio.inscritos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProjectNotExistOrNotFound extends DesafioException {

  private final String detail;

  public ProjectNotExistOrNotFound(String detail) {
    super(detail);
    this.detail = detail;
  }

  @Override
  public ProblemDetail toProblemDetail() {
    var pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

    pd.setTitle("Projeto não existe ou não foi encontrado");
    pd.setDetail(detail);

    return pd;
  }
}
