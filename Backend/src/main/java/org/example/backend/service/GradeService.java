package org.example.backend.service;

import org.example.backend.domain.Classroom;
import org.example.backend.domain.Grade;
import org.example.backend.dto.*;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.GradeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GradeService {

    private GradeRepository gradeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setGradeRepository(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<GradeDto> getGrades() {
        return gradeRepository.findAll().stream().map((e) -> modelMapper.map(e, GradeDto.class)).toList();
    }

    public GradeDto getGrade(Integer id) {
        return gradeRepository.findById(id).map((e) -> modelMapper.map(e, GradeDto.class)).orElse(null);
    }

    public void saveGrade(GradeDto gradeDto) {
        Grade grade = modelMapper.map(gradeDto, Grade.class);
        gradeRepository.save(grade);
    }

    public void updateGrade(GradeDto gradeDto) {
        Grade grade = modelMapper.map(gradeDto, Grade.class);
        gradeRepository.save(grade);
    }

    public void deleteGrade(Integer id) {
        gradeRepository.deleteById(id);
    }

    public List<GradeDto> getStudentsGrades(UserDto userDto, Integer classId, Integer subjectId) {
        return gradeRepository.findGradesByClassAndSubjectId(userDto.getId(), classId, subjectId).stream().map((e) -> modelMapper.map(e, GradeDto.class)).toList();
    }
}
