package dev.matheuslf.desafio.inscritos.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequestDTO(
    @NotBlank
    String name,

    String description) {
}
