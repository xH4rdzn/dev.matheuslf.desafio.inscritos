package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dto.request.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.request.TaskUpdateDTO;
import dev.matheuslf.desafio.inscritos.dto.response.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.domain.models.Task;
import dev.matheuslf.desafio.inscritos.exceptions.ProjectNotExistOrNotFound;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

  private final TaskRepository taskRepository;
  private final ProjectRepository projectRepository;
  private final TaskMapper mapper;

  public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository, TaskMapper mapper) {
    this.taskRepository = taskRepository;
    this.projectRepository = projectRepository;
    this.mapper = mapper;
  }


  public TaskResponseDTO create(TaskRequestDTO dto) {

    var project = projectRepository.findById(dto.projectId());

    if (!project.isPresent()) {
      throw new ProjectNotExistOrNotFound("O projeto não Existe ou não foi encontrado!");
    }
    Task entity = mapper.toEntity(dto, project.get());
    taskRepository.save(entity);
    return mapper.toResponse(entity);

  }

  public List<TaskResponseDTO> findAll() {
    return taskRepository.findAll().stream().map(mapper::toResponse).toList();
  }

  public Optional<Task> updateTaskStatus(Long id, TaskUpdateDTO dto) {
    var task = taskRepository.findById(id);

    if (task.isPresent()) {
      task.get().setStatus(dto.status());
    }

    taskRepository.save(task.get());

    return task;
  }

  public boolean deleteById(Long id) {

    var exists = taskRepository.existsById(id);

    if(exists) {
      taskRepository.deleteById(id);
      return true;
    }

    return false;

  }
}
