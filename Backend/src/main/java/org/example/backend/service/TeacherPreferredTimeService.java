package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.dto.SubjectSubjectRequirementDto;
import org.example.backend.dto.SubjectSubjectRequirementIdDto;
import org.example.backend.dto.TeacherPreferredTimeDto;
import org.example.backend.dto.TeacherPreferredTimeIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherPreferredTimeService {

    private TeacherPreferredTimeRepository teacherPreferredTimeRepository;
    private ModelMapper modelMapper;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PreferredTimeRepository preferredTimeRepository;

    @Autowired
    public void setTeacherPreferredTimeRepository(TeacherPreferredTimeRepository teacherPreferredTimeRepository) {
        this.teacherPreferredTimeRepository = teacherPreferredTimeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<TeacherPreferredTimeDto> getTeacherPreferredTimes() {
        return teacherPreferredTimeRepository.findAll().stream().map((e) -> modelMapper.map(e, TeacherPreferredTimeDto.class)).toList();
    }

    public TeacherPreferredTimeDto getTeacherPreferredTime(String teacherId, Integer preferredTimeId) {
        TeacherPreferredTimeId teacherPreferredTimeId = new TeacherPreferredTimeId(teacherId, preferredTimeId);
        return teacherPreferredTimeRepository.findById(teacherPreferredTimeId).map((e) -> modelMapper.map(e, TeacherPreferredTimeDto.class)).orElse(null);
    }

    public void saveTeacherPreferredTime(TeacherPreferredTimeIdDto teacherPreferredTimeIdDto) {
        TeacherPreferredTimeId teacherPreferredTimeId = modelMapper.map(teacherPreferredTimeIdDto, TeacherPreferredTimeId.class);

        Teacher teacher = teacherRepository.findById(teacherPreferredTimeId.getTeacherId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        PreferredTime preferredTime = preferredTimeRepository.findById(teacherPreferredTimeId.getPreferredTimeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid preferred time ID"));

        TeacherPreferredTime teacherPreferredTime = new TeacherPreferredTime();
        teacherPreferredTime.setTeacher(teacher);
        teacherPreferredTime.setPreferredTime(preferredTime);

        teacherPreferredTime.setId(teacherPreferredTimeId);

        teacherPreferredTimeRepository.save(teacherPreferredTime);
    }

    public void updateTeacherPreferredTime(TeacherPreferredTimeIdDto teacherPreferredTimeIdDto) {
        TeacherPreferredTimeId teacherPreferredTimeId = modelMapper.map(teacherPreferredTimeIdDto, TeacherPreferredTimeId.class);

        Teacher teacher = teacherRepository.findById(teacherPreferredTimeId.getTeacherId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        PreferredTime preferredTime = preferredTimeRepository.findById(teacherPreferredTimeId.getPreferredTimeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid preferred time ID"));

        TeacherPreferredTime teacherPreferredTime = new TeacherPreferredTime();
        teacherPreferredTime.setTeacher(teacher);
        teacherPreferredTime.setPreferredTime(preferredTime);

        teacherPreferredTime.setId(teacherPreferredTimeId);

        teacherPreferredTimeRepository.save(teacherPreferredTime);
    }


    public void deleteTeacherPreferredTime(String teacherId, Integer preferredTimeId) {
        TeacherPreferredTimeId teacherPreferredTimeId = new TeacherPreferredTimeId(teacherId, preferredTimeId);
        teacherPreferredTimeRepository.deleteById(teacherPreferredTimeId);
    }
}
