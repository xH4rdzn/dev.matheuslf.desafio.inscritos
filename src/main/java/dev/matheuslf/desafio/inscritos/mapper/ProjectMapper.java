package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dto.request.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

  public Project toEntity(ProjectRequestDTO request) {
    Project entity = new Project();
    entity.setName(request.name());
    entity.setDescription(request.description());

    return entity;
  }

  public ProjectResponseDTO toResponse(Project entity) {
    return new ProjectResponseDTO(
        entity.getId(),
        entity.getName(),
        entity.getDescription(),
        entity.getStatus(),
        entity.getStartDate(),
        entity.getEndDate()
    );
  }
}
