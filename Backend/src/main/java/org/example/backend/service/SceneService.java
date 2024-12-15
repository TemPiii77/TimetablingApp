package org.example.backend.service;

import org.example.backend.domain.Grade;
import org.example.backend.domain.Scene;
import org.example.backend.dto.AbsenceDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.SceneDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.GradeRepository;
import org.example.backend.repository.SceneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SceneService {

    @Value("${currentYear}")
    private String year;

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

    public List<SceneDto> getUsersScenes(UserDto userDto, Integer year) {

        return switch (userDto.getRole()) {
            case "ROLE_STUDENT" -> sceneRepository.findStudentsScenes(userDto.getId(), year).stream().map((e) -> modelMapper.map(e, SceneDto.class)).toList();
            case "ROLE_TEACHER" -> sceneRepository.findTeachersScenes(userDto.getId(), year).stream().map((e) -> modelMapper.map(e, SceneDto.class)).toList();
            default -> sceneRepository.findAdminsScenes(year).stream().map((e) -> modelMapper.map(e, SceneDto.class)).toList();
        };

    }
}
