package org.example.backend.service;

import org.example.backend.domain.Grade;
import org.example.backend.domain.ScenePart;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.ScenePartDto;
import org.example.backend.repository.GradeRepository;
import org.example.backend.repository.ScenePartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenePartService {

    private ScenePartRepository scenePartRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setScenePartRepository(ScenePartRepository scenePartRepository) {
        this.scenePartRepository = scenePartRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ScenePartDto> getSceneParts() {
        return scenePartRepository.findAll().stream().map((e) -> modelMapper.map(e, ScenePartDto.class)).toList();
    }

    public List<ScenePartDto> getScenePart(Integer id) {
        return scenePartRepository.findBySceneId(id).stream().map((e) -> modelMapper.map(e, ScenePartDto.class)).toList();
    }

    public void saveScenePart(ScenePartDto scenePartDto) {
        ScenePart scenePart = modelMapper.map(scenePartDto, ScenePart.class);
        scenePartRepository.save(scenePart);
    }

    public void updateScenePart(ScenePartDto scenePartDto) {
        ScenePart scenePart = modelMapper.map(scenePartDto, ScenePart.class);
        scenePartRepository.save(scenePart);
    }

    public void deleteScenePart(Integer id) {
        scenePartRepository.deleteById(id);
    }
}
