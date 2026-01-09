package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dto.request.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.mapper.ProjectMapper;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper mapper;

  public ProjectService(ProjectRepository projectRepository, ProjectMapper mapper) {
    this.projectRepository = projectRepository;
    this.mapper = mapper;
  }


  public ProjectResponseDTO create(ProjectRequestDTO dto) {
    Project entity = mapper.toEntity(dto);
    projectRepository.save(entity);
    return mapper.toResponse(entity);
  }

  public Page<ProjectResponseDTO> findAll(Integer page, Integer pageSize) {
    var pageRequest = PageRequest.of(page, pageSize);

    return projectRepository
        .findAll(pageRequest)
        .map(mapper::toResponse);
  }
}
