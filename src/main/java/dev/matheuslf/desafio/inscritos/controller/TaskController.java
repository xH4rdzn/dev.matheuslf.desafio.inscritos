package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dto.request.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public ResponseEntity<Void> createTask(@Valid @RequestBody TaskRequestDTO dto) {

    var task = taskService.create(dto);

    return ResponseEntity.created(URI.create("/tasks/" + task.id())).build();
  }

  @GetMapping
  public ResponseEntity<List<TaskResponseDTO>> findAll() {
    return ResponseEntity.ok(taskService.findAll());
  }

}
