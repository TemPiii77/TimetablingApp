package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.dto.SubjectSubjectRequirementDto;
import org.example.backend.dto.SubjectSubjectRequirementIdDto;
import org.example.backend.dto.TeacherSceneDto;
import org.example.backend.dto.TeacherSceneIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherSceneService {

    private TeacherSceneRepository teacherSceneRepository;
    private ModelMapper modelMapper;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SceneRepository sceneRepository;

    @Autowired
    public void setTeacherSceneRepository(TeacherSceneRepository teacherSceneRepository) {
        this.teacherSceneRepository = teacherSceneRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<TeacherSceneDto> getTeacherScenes() {
        return teacherSceneRepository.findAll().stream().map((e) -> modelMapper.map(e, TeacherSceneDto.class)).toList();
    }

    public TeacherSceneDto getTeacherScene(String teacherId, Integer SceneId) {
        TeacherSceneId teacherSceneId = new TeacherSceneId(teacherId, SceneId);
        return teacherSceneRepository.findById(teacherSceneId).map((e) -> modelMapper.map(e, TeacherSceneDto.class)).orElse(null);
    }

    public void saveTeacherScene(TeacherSceneIdDto teacherSceneIdDto) {
        TeacherSceneId teacherSceneId = modelMapper.map(teacherSceneIdDto, TeacherSceneId.class);

        Teacher teacher = teacherRepository.findById(teacherSceneId.getTeacherId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        Scene scene = sceneRepository.findById(teacherSceneId.getSceneId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid scene ID"));

        TeacherScene teacherScene = new TeacherScene();
        teacherScene.setTeacher(teacher);
        teacherScene.setScene(scene);

        teacherScene.setId(teacherSceneId);

        teacherSceneRepository.save(teacherScene);
    }

    public void updateTeacherScene(TeacherSceneIdDto teacherSceneIdDto) {
        TeacherSceneId teacherSceneId = modelMapper.map(teacherSceneIdDto, TeacherSceneId.class);

        Teacher teacher = teacherRepository.findById(teacherSceneId.getTeacherId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));

        Scene scene = sceneRepository.findById(teacherSceneId.getSceneId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid scene ID"));

        TeacherScene teacherScene = new TeacherScene();
        teacherScene.setTeacher(teacher);
        teacherScene.setScene(scene);

        teacherScene.setId(teacherSceneId);

        teacherSceneRepository.save(teacherScene);
    }


    public void deleteTeacherScene(String teacherId, Integer SceneId) {
        TeacherSceneId teacherSceneId = new TeacherSceneId(teacherId, SceneId);
        teacherSceneRepository.deleteById(teacherSceneId);
    }

}
