package dev.matheuslf.desafio.inscritos.exceptions;

import dev.matheuslf.desafio.inscritos.dto.InvalidParamDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DesafioException.class)
  public ProblemDetail handleDesafioException(DesafioException e) {
    return e.toProblemDetail();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    var invalidParams = e.getFieldErrors()
        .stream().map(fe -> new InvalidParamDTO(fe.getField(), fe.getDefaultMessage()))
        .toList();

    var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    pd.setTitle("Parâmetros de requisição inválidos");
    pd.setDetail("Os campos abaixo estão inválidos");
    pd.setProperty("invalid-params", invalidParams);

    return pd;
  }

}
