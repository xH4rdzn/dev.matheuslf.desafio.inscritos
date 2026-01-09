package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dto.request.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/projects")
public class ProjectController {

  private final ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }


  @PostMapping
  public ResponseEntity<Void> createProject(@Valid @RequestBody ProjectRequestDTO dto) {

    var project = projectService.create(dto);

    return ResponseEntity.created(URI.create("/projects/" + project.id())).build();
  }

  @GetMapping
  public ResponseEntity<Page<ProjectResponseDTO>> listAllProjects(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
    var projects = projectService.findAll(page, pageSize);

    return ResponseEntity.ok(projects);
  }

}
