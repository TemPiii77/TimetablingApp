package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.SubjectSubjectRequirementDto;
import org.example.backend.dto.SubjectSubjectRequirementIdDto;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.SubjectRepository;
import org.example.backend.repository.SubjectRequirementRepository;
import org.example.backend.repository.SubjectSubjectRequirementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectSubjectRequirementService {

    private SubjectSubjectRequirementRepository subjectSubjectRequirementRepository;
    private ModelMapper modelMapper;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubjectRequirementRepository subjectRequirementRepository;

    @Autowired
    public void setSubjectSubjectRequirementRepository(SubjectSubjectRequirementRepository subjectSubjectRequirementRepository) {
        this.subjectSubjectRequirementRepository = subjectSubjectRequirementRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<SubjectSubjectRequirementDto> getSubjectSubjectRequirements() {
        return subjectSubjectRequirementRepository.findAll().stream().map((e) -> modelMapper.map(e, SubjectSubjectRequirementDto.class)).toList();
    }

    public SubjectSubjectRequirementDto getSubjectSubjectRequirement(Integer subjectId, Integer subjectRequirementId) {
        SubjectSubjectRequirementId subjectSubjectRequirementId = new SubjectSubjectRequirementId(subjectId, subjectRequirementId);
        return subjectSubjectRequirementRepository.findById(subjectSubjectRequirementId).map((e) -> modelMapper.map(e, SubjectSubjectRequirementDto.class)).orElse(null);
    }

    public void saveSubjectSubjectRequirement(SubjectSubjectRequirementIdDto subjectSubjectRequirementIdDto) {
        SubjectSubjectRequirementId subjectSubjectRequirementId = modelMapper.map(subjectSubjectRequirementIdDto, SubjectSubjectRequirementId.class);

        Subject subject = subjectRepository.findById(subjectSubjectRequirementId.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        SubjectRequirement subjectRequirement = subjectRequirementRepository.findById(subjectSubjectRequirementId.getSubjectRequirementId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject requirement ID"));

        SubjectSubjectRequirement subjectSubjectRequirement = new SubjectSubjectRequirement();
        subjectSubjectRequirement.setSubject(subject);
        subjectSubjectRequirement.setSubjectRequirement(subjectRequirement);

        subjectSubjectRequirement.setId(subjectSubjectRequirementId);

        subjectSubjectRequirementRepository.save(subjectSubjectRequirement);
    }

    public void updateSubjectSubjectRequirement(SubjectSubjectRequirementIdDto subjectSubjectRequirementIdDto) {
        SubjectSubjectRequirementId subjectSubjectRequirementId = modelMapper.map(subjectSubjectRequirementIdDto, SubjectSubjectRequirementId.class);

        Subject subject = subjectRepository.findById(subjectSubjectRequirementId.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        SubjectRequirement subjectRequirement = subjectRequirementRepository.findById(subjectSubjectRequirementId.getSubjectRequirementId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject requirement ID"));

        SubjectSubjectRequirement subjectSubjectRequirement = new SubjectSubjectRequirement();
        subjectSubjectRequirement.setSubject(subject);
        subjectSubjectRequirement.setSubjectRequirement(subjectRequirement);

        subjectSubjectRequirement.setId(subjectSubjectRequirementId);

        subjectSubjectRequirementRepository.save(subjectSubjectRequirement);
    }


    public void deleteSubjectSubjectRequirement(Integer subjectId, Integer subjectRequirementId) {
        SubjectSubjectRequirementId subjectSubjectRequirementId = new SubjectSubjectRequirementId(subjectId, subjectRequirementId);
        subjectSubjectRequirementRepository.deleteById(subjectSubjectRequirementId);
    }
}
