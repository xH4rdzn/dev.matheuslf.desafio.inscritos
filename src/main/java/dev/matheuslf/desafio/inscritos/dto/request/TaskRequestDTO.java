package dev.matheuslf.desafio.inscritos.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.matheuslf.desafio.inscritos.entity.PriorityTask;
import dev.matheuslf.desafio.inscritos.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequestDTO(
                          @NotBlank
                          @Size(min = 5, max = 150)
                          String title,


                          String description,


                          TaskStatus status,

                          @NotNull
                          PriorityTask priority,

                          @NotNull
                          Long projectId,

                          @JsonFormat(pattern = "dd/MM/yyyy")
                          @NotNull
                          LocalDate dueDate) {
}
