package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.domain.Class;
import org.example.backend.dto.StudentClassDto;
import org.example.backend.dto.StudentClassIdDto;
import org.example.backend.dto.SubjectSubjectRequirementDto;
import org.example.backend.dto.SubjectSubjectRequirementIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {

    private StudentClassRepository studentClassRepository;
    private ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    public void setStudentClassRepository(StudentClassRepository studentClassRepository) {
        this.studentClassRepository = studentClassRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<StudentClassDto> getStudentClasses() {
        return studentClassRepository.findAll().stream().map((e) -> modelMapper.map(e, StudentClassDto.class)).toList();
    }

    public StudentClassDto getStudentClass(String studentId, Integer classId) {
        StudentClassId studentClassId = new StudentClassId(studentId, classId);
        return studentClassRepository.findById(studentClassId).map((e) -> modelMapper.map(e, StudentClassDto.class)).orElse(null);
    }

    public void saveStudentClass(StudentClassIdDto studentClassIdDto) {
        StudentClassId studentClassId = modelMapper.map(studentClassIdDto, StudentClassId.class);

        Student student = studentRepository.findById(studentClassId.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        Class classField = classRepository.findById(studentClassId.getClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID"));


        StudentClass studentClass = new StudentClass();
        studentClass.setStudent(student);
        studentClass.setClass(classField);

        studentClass.setId(studentClassId);

        studentClassRepository.save(studentClass);
    }

    public void updateStudentClass(StudentClassIdDto studentClassIdDto) {
        StudentClassId studentClassId = modelMapper.map(studentClassIdDto, StudentClassId.class);

        Student student = studentRepository.findById(studentClassId.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        Class classField = classRepository.findById(studentClassId.getClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID"));

        StudentClass studentClass = new StudentClass();
        studentClass.setStudent(student);
        studentClass.setClass(classField);

        studentClass.setId(studentClassId);

        studentClassRepository.save(studentClass);
    }


    public void deleteStudentClass(String studentId, Integer classId) {
        StudentClassId studentClassId = new StudentClassId(studentId, classId);
        studentClassRepository.deleteById(studentClassId);
    }
}
