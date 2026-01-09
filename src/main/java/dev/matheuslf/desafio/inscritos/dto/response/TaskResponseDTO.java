package dev.matheuslf.desafio.inscritos.dto.response;

import dev.matheuslf.desafio.inscritos.dto.ProjectSummaryDTO;
import dev.matheuslf.desafio.inscritos.domain.enums.PriorityTask;
import dev.matheuslf.desafio.inscritos.domain.enums.TaskStatus;

import java.time.LocalDate;

public record TaskResponseDTO(Long id,
                              String title,
                              String description,
                              TaskStatus status,
                              PriorityTask priority,
                              LocalDate dueDate,
                              ProjectSummaryDTO project) {
}
