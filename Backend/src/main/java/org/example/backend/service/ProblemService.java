package org.example.backend.service;

import org.example.backend.domain.Grade;
import org.example.backend.domain.Problem;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.ProblemDto;
import org.example.backend.repository.GradeRepository;
import org.example.backend.repository.ProblemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    private ProblemRepository problemRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setProblemRepository(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ProblemDto> getProblems() {
        return problemRepository.findAll().stream().map((e) -> modelMapper.map(e, ProblemDto.class)).toList();
    }

    public ProblemDto getProblem(Integer id) {
        return problemRepository.findById(id).map((e) -> modelMapper.map(e, ProblemDto.class)).orElse(null);
    }

    public void saveProblem(ProblemDto problemDto) {
        Problem problem = modelMapper.map(problemDto, Problem.class);
        problemRepository.save(problem);
    }

    public void updateProblem(ProblemDto problemDto) {
        Problem problem = modelMapper.map(problemDto, Problem.class);
        problemRepository.save(problem);
    }

    public void deleteProblem(Integer id) {
        problemRepository.deleteById(id);
    }
}
