package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.domain.Class;
import org.example.backend.dto.ClassSubjectDto;
import org.example.backend.dto.ClassSubjectIdDto;
import org.example.backend.dto.SubjectSubjectRequirementDto;
import org.example.backend.dto.SubjectSubjectRequirementIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSubjectService {

    private ClassSubjectRepository classSubjectRepository;
    private ModelMapper modelMapper;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    public void setClassSubjectRepository(ClassSubjectRepository classSubjectRepository) {
        this.classSubjectRepository = classSubjectRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ClassSubjectDto> getClassSubjects() {
        return classSubjectRepository.findAll().stream().map((e) -> modelMapper.map(e, ClassSubjectDto.class)).toList();
    }

    public ClassSubjectDto getClassSubject(Integer classId, Integer subjectId) {
        ClassSubjectId classSubjectId = new ClassSubjectId(classId, subjectId);
        return classSubjectRepository.findById(classSubjectId).map((e) -> modelMapper.map(e, ClassSubjectDto.class)).orElse(null);
    }

    public void saveClassSubject(ClassSubjectIdDto classSubjectIdDto) {
        ClassSubjectId classSubjectId = modelMapper.map(classSubjectIdDto, ClassSubjectId.class);

        Class classField = classRepository.findById(classSubjectId.getClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID"));

        Subject subject = subjectRepository.findById(classSubjectId.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        ClassSubject classSubject = new ClassSubject();
        classSubject.setClass(classField);
        classSubject.setSubject(subject);

        classSubject.setId(classSubjectId);

        classSubjectRepository.save(classSubject);
    }

    public void updateClassSubject(ClassSubjectIdDto classSubjectIdDto) {
        ClassSubjectId classSubjectId = modelMapper.map(classSubjectIdDto, ClassSubjectId.class);

        Class classField = classRepository.findById(classSubjectId.getClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID"));

        Subject subject = subjectRepository.findById(classSubjectId.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        ClassSubject classSubject = new ClassSubject();
        classSubject.setClass(classField);
        classSubject.setSubject(subject);

        classSubject.setId(classSubjectId);

        classSubjectRepository.save(classSubject);
    }


    public void deleteClassSubject(Integer classId, Integer subjectId) {
        ClassSubjectId classSubjectId = new ClassSubjectId(classId, subjectId);
        classSubjectRepository.deleteById(classSubjectId);
    }
}
