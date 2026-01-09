package dev.matheuslf.desafio.inscritos.dto.request;

import dev.matheuslf.desafio.inscritos.domain.enums.ProjectStatus;

public record ProjectUpdateRequestDTO(ProjectStatus status) {
}
