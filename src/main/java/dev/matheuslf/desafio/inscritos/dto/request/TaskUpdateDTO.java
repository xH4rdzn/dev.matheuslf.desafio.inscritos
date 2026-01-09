package dev.matheuslf.desafio.inscritos.dto.request;

import dev.matheuslf.desafio.inscritos.domain.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record TaskUpdateDTO(@NotNull TaskStatus status) {
}
