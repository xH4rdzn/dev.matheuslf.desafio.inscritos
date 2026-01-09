package dev.matheuslf.desafio.inscritos.dto.response;

import dev.matheuslf.desafio.inscritos.domain.enums.ProjectStatus;

import java.time.LocalDate;

public record ProjectResponseDTO(Long id,
                                 String name,
                                 String description,
                                 ProjectStatus status,
                                 LocalDate startDate,
                                 LocalDate endDate) {
}
