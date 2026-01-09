package dev.matheuslf.desafio.inscritos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectSummaryDTO(
                                @NotNull
                                Long id,

                                @NotBlank
                                String title) {
}
