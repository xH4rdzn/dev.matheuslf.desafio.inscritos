package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dto.ProjectSummaryDTO;
import dev.matheuslf.desafio.inscritos.dto.request.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

  public Task toEntity(TaskRequestDTO request, Project project) {
    Task entity = new Task();
    entity.setTitle(request.title());
    entity.setDescription(request.description());
    entity.setStatus(request.status());
    entity.setPriority(request.priority());
    entity.setProject(project);
    entity.setDueDate(request.dueDate());

    return entity;
  }

  public TaskResponseDTO toResponse(Task entity) {
    return new TaskResponseDTO(
        entity.getId(),
        entity.getTitle(),
        entity.getDescription(),
        entity.getStatus(),
        entity.getPriority(),
        entity.getDueDate(),
        new ProjectSummaryDTO(
            entity.getProject().getId(),
            entity.getProject().getName()
        )
    );
  }


}
