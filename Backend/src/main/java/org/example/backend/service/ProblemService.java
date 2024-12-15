package org.example.backend.service;

import org.example.backend.domain.Grade;
import org.example.backend.domain.Problem;
import org.example.backend.dto.AbsenceDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.ProblemDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.GradeRepository;
import org.example.backend.repository.ProblemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    public List<ProblemDto> getStudentsProblems(UserDto userDto, Integer year) {

        String minimumYear = year + "-09-01";
        String maximumYear = (year+1) + "-07-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate minLocalDate = LocalDate.parse(minimumYear, formatter);
        LocalDate maxLocalDate = LocalDate.parse(maximumYear, formatter);

        Instant minYear = minLocalDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
        Instant maxYear = maxLocalDate.atStartOfDay(ZoneId.of("UTC")).toInstant();

        return problemRepository.findProblemsByYear(userDto.getId(), minYear, maxYear).stream().map((e) -> modelMapper.map(e, ProblemDto.class)).toList();
    }
}
