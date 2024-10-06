package org.example.backend.service;

import org.example.backend.domain.Grade;
import org.example.backend.domain.Scene;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.SceneDto;
import org.example.backend.repository.GradeRepository;
import org.example.backend.repository.SceneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {

    private SceneRepository sceneRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setSceneRepository(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<SceneDto> getScenes() {
        return sceneRepository.findAll().stream().map((e) -> modelMapper.map(e, SceneDto.class)).toList();
    }

    public SceneDto getScene(Integer id) {
        return sceneRepository.findById(id).map((e) -> modelMapper.map(e, SceneDto.class)).orElse(null);
    }

    public void saveScene(SceneDto sceneDto) {
        Scene scene = modelMapper.map(sceneDto, Scene.class);
        sceneRepository.save(scene);
    }

    public void updateScene(SceneDto sceneDto) {
        Scene scene = modelMapper.map(sceneDto, Scene.class);
        sceneRepository.save(scene);
    }

    public void deleteScene(Integer id) {
        sceneRepository.deleteById(id);
    }

}
