package org.example.backend.service;

import org.example.backend.domain.Classroom;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ClassroomService {

    private ClassroomRepository classroomRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setClassroomRepository(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ClassroomDto> getClassrooms() {
        return classroomRepository.findAll().stream().map((e) -> modelMapper.map(e, ClassroomDto.class)).toList();
    }

    public ClassroomDto getClassroom(Integer id) {
        return classroomRepository.findById(id).map((e) -> modelMapper.map(e, ClassroomDto.class)).orElse(null);
    }

    public void saveClassroom(ClassroomDto classroomDto) {
        Classroom classroom = modelMapper.map(classroomDto, Classroom.class);
        classroomRepository.save(classroom);
    }

    public void updateClassroom(ClassroomDto classroomDto) {
        Classroom classroom = modelMapper.map(classroomDto, Classroom.class);
        classroomRepository.save(classroom);
    }

    public void deleteClassroom(Integer id) {
        classroomRepository.deleteById(id);
    }
}
