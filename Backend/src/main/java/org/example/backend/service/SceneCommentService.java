package org.example.backend.service;

import org.example.backend.domain.Grade;
import org.example.backend.domain.SceneComment;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.SceneCommentDto;
import org.example.backend.dto.ScenePartDto;
import org.example.backend.repository.GradeRepository;
import org.example.backend.repository.SceneCommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneCommentService {

    private SceneCommentRepository sceneCommentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setSceneCommentRepository(SceneCommentRepository sceneCommentRepository) {
        this.sceneCommentRepository = sceneCommentRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<SceneCommentDto> getSceneComments() {
        return sceneCommentRepository.findAll().stream().map((e) -> modelMapper.map(e, SceneCommentDto.class)).toList();
    }

    public List<SceneCommentDto> getSceneComment(Integer id) {
        return sceneCommentRepository.findByScenePartIdOrderByDateRecordedDesc(id).stream().map((e) -> modelMapper.map(e, SceneCommentDto.class)).toList();
    }

    public void saveSceneComment(SceneCommentDto sceneCommentDto) {
        SceneComment sceneComment = modelMapper.map(sceneCommentDto, SceneComment.class);
        sceneCommentRepository.save(sceneComment);
    }

    public void updateSceneComment(SceneCommentDto sceneCommentDto) {
        SceneComment sceneComment = modelMapper.map(sceneCommentDto, SceneComment.class);
        sceneCommentRepository.save(sceneComment);
    }

    public void deleteSceneComment(Integer id) {
        sceneCommentRepository.deleteById(id);
    }
}
