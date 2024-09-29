package org.example.backend.service;

import org.example.backend.domain.Classroom;
import org.example.backend.domain.Subject;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.SubjectDto;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<SubjectDto> getSubjects() {
        return subjectRepository.findAll().stream().map((e) -> modelMapper.map(e, SubjectDto.class)).toList();
    }

    public SubjectDto getSubject(Integer id) {
        return subjectRepository.findById(id).map((e) -> modelMapper.map(e, SubjectDto.class)).orElse(null);
    }

    public void saveSubject(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        subjectRepository.save(subject);
    }

    public void updateSubject(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        subjectRepository.save(subject);
    }

    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }



}
