package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.dto.SubjectSubjectRequirementDto;
import org.example.backend.dto.SubjectSubjectRequirementIdDto;
import org.example.backend.dto.TeacherSubjectDto;
import org.example.backend.dto.TeacherSubjectIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherSubjectService {

    private TeacherSubjectRepository teacherSubjectRepository;
    private ModelMapper modelMapper;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    public void setTeacherSubjectRepository(TeacherSubjectRepository teacherSubjectRepository) {
        this.teacherSubjectRepository = teacherSubjectRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<TeacherSubjectDto> getTeacherSubjects() {
        return teacherSubjectRepository.findAll().stream().map((e) -> modelMapper.map(e, TeacherSubjectDto.class)).toList();
    }

    public TeacherSubjectDto getTeacherSubject(String teacherId, Integer subjectId) {
        TeacherSubjectId teacherSubjectId = new TeacherSubjectId(teacherId, subjectId);
        return teacherSubjectRepository.findById(teacherSubjectId).map((e) -> modelMapper.map(e, TeacherSubjectDto.class)).orElse(null);
    }

    public void saveTeacherSubject(TeacherSubjectIdDto teacherSubjectIdDto) {
        TeacherSubjectId teacherSubjectId = modelMapper.map(teacherSubjectIdDto, TeacherSubjectId.class);

        Teacher teacher = teacherRepository.findById(teacherSubjectId.getTeacherId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        Subject subject = subjectRepository.findById(teacherSubjectId.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        TeacherSubject teacherSubject = new TeacherSubject();
        teacherSubject.setTeacher(teacher);
        teacherSubject.setSubject(subject);

        teacherSubject.setId(teacherSubjectId);

        teacherSubjectRepository.save(teacherSubject);
    }

    public void updateTeacherSubject(TeacherSubjectIdDto teacherSubjectIdDto) {
        TeacherSubjectId teacherSubjectId = modelMapper.map(teacherSubjectIdDto, TeacherSubjectId.class);

        Teacher teacher = teacherRepository.findById(teacherSubjectId.getTeacherId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        Subject subject = subjectRepository.findById(teacherSubjectId.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        TeacherSubject teacherSubject = new TeacherSubject();
        teacherSubject.setTeacher(teacher);
        teacherSubject.setSubject(subject);

        teacherSubject.setId(teacherSubjectId);

        teacherSubjectRepository.save(teacherSubject);
    }


    public void deleteTeacherSubject(String teacherId, Integer subjectId) {
        TeacherSubjectId teacherSubjectId = new TeacherSubjectId(teacherId, subjectId);
        teacherSubjectRepository.deleteById(teacherSubjectId);
    }
}
