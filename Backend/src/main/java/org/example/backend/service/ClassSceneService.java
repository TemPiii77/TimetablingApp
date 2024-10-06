package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.domain.Class;
import org.example.backend.dto.ClassSceneDto;
import org.example.backend.dto.ClassSceneIdDto;
import org.example.backend.dto.TeacherSceneDto;
import org.example.backend.dto.TeacherSceneIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSceneService {

    private ClassSceneRepository classSceneRepository;
    private ModelMapper modelMapper;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    SceneRepository sceneRepository;

    @Autowired
    public void setClassSceneRepository(ClassSceneRepository classSceneRepository) {
        this.classSceneRepository = classSceneRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ClassSceneDto> getClassScenes() {
        return classSceneRepository.findAll().stream().map((e) -> modelMapper.map(e, ClassSceneDto.class)).toList();
    }

    public ClassSceneDto getClassScene(Integer classId, Integer sceneId) {
        ClassSceneId classSceneId = new ClassSceneId(classId, sceneId);
        return classSceneRepository.findById(classSceneId).map((e) -> modelMapper.map(e, ClassSceneDto.class)).orElse(null);
    }

    public void saveClassScene(ClassSceneIdDto classSceneIdDto) {
        ClassSceneId classSceneId = modelMapper.map(classSceneIdDto, ClassSceneId.class);

        Class classField = classRepository.findById(classSceneId.getClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID"));

        Scene scene = sceneRepository.findById(classSceneId.getSceneId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid scene ID"));

        ClassScene classScene = new ClassScene();
        classScene.setClassField(classField);
        classScene.setScene(scene);

        classScene.setId(classSceneId);

        classSceneRepository.save(classScene);
    }

    public void updateClassScene(ClassSceneIdDto classSceneIdDto) {
        ClassSceneId classSceneId = modelMapper.map(classSceneIdDto, ClassSceneId.class);

        Class classField = classRepository.findById(classSceneId.getClassId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID"));

        Scene scene = sceneRepository.findById(classSceneId.getSceneId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid scene ID"));

        ClassScene classScene = new ClassScene();
        classScene.setClassField(classField);
        classScene.setScene(scene);

        classScene.setId(classSceneId);

        classSceneRepository.save(classScene);
    }


    public void deleteClassScene(Integer classId, Integer sceneId) {
        ClassSceneId classSceneId = new ClassSceneId(classId, sceneId);
        classSceneRepository.deleteById(classSceneId);
    }

}
